package chess.pieces;

import chess.Board;
import chess.Direction;
import chess.Position;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Queen extends Piece {
    private static final List<Direction> directions = Direction.everyDirection();

    protected Queen(Type type, Color color) {
        super(type, color);
    }

    @Override
    public Set<Position> getValidMoves(Board board) {
        Set<Position> validMoves = new HashSet<>();

        for (Direction direction : directions) {
            for (int dist = 1; dist <= Board.SIZE; dist++) {
                int newRank = position.rank + direction.getRankDelta() * dist;
                int newFile = position.file + direction.getFileDelta() * dist;

                if (newRank < 0 || newRank >= Board.SIZE || newFile < 0 || newFile >= Board.SIZE) {
                    break;
                }

                Piece piece = board.getRank(newRank).get(newFile);

                if (piece.getColor() == this.color) { // 아군
                    break;
                }

                validMoves.add(new Position(newRank, newFile));

                if (piece.getType() != Type.NO_PIECE) { // 진행 불가
                    break;
                }
            }
        }
        return validMoves;
    }
}
