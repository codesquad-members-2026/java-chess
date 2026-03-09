package chess.pieces;

import chess.Board;
import chess.Direction;
import chess.Position;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Pawn extends Piece {
    private static final Map<Color, List<Direction>> directions = Map.of(
            Color.WHITE, Direction.whitePawnDirection(),
            Color.BLACK, Direction.blackPawnDirection());
    private static final List<Direction> diagonalDirections = Direction.diagonalDirection();

    private boolean hasMoved = false;

    protected Pawn(Type type, Color color) {
        super(type, color);
    }

    @Override
    public Set<Position> getValidMoves(Position from, Board board) {
        Set<Position> validMoves = new HashSet<>();

        for (Direction direction : directions.get(getColor())) {
            int newRank = from.rank + direction.getRankDelta();
            int newFile = from.file + direction.getFileDelta();

            if (newRank < 0 || newRank >= Board.SIZE || newFile < 0 || newFile >= Board.SIZE) {
                continue;
            }

            Position to = new Position(newRank, newFile);
            Piece piece = board.findPiece(to);
            if (piece.getColor() == this.color) {
                continue;
            }

            if (diagonalDirections.contains(direction)) { // 대각
                if (piece.getType() != Type.NO_PIECE) {
                    validMoves.add(to);
                }
            } else { // 전진
                if (piece.getType() == Type.NO_PIECE) {
                    validMoves.add(to);

                    if (hasMoved) {
                        continue;
                    }

                    newRank += direction.getRankDelta();
                    newFile += direction.getFileDelta();
                    Position doublePushedPosition = new Position(newRank, newFile);

                    Piece doublePushed = board.findPiece(doublePushedPosition);

                    if (doublePushed.getType() == Type.NO_PIECE) {
                        validMoves.add(doublePushedPosition);
                    }
                }
            }
        }
        return validMoves;
    }

    public void moved() {
        hasMoved = true;
    }
}
