package chess.pieces;

import chess.Board;
import chess.Direction;
import chess.Position;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Knight extends Piece {
    private static final List<Direction> directions = Direction.knightDirection();

    protected Knight(Type type, Color color) {
        super(type, color);
    }

    @Override
    public Set<Position> getValidMoves(Position from, Board board) {
        Set<Position> validMoves = new HashSet<>();

        for (Direction direction : directions) {
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

            validMoves.add(new Position(newRank, newFile));
        }
        return validMoves;
    }
}
