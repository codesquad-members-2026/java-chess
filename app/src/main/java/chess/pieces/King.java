package chess.pieces;

import chess.Board;
import chess.Direction;
import chess.Position;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    private static final List<Direction> directions = Direction.everyDirection();

    protected King(Type type, Color color, Position position) {
        super(type, color, position);
    }
    @Override
    public List<Position> getValidMoves(Board board) {
        List<Position> validMoves = new ArrayList<>();

        for (Direction direction : directions) {
            int newRank = position.rank + direction.getRankDelta();
            int newFile = position.file + direction.getFileDelta();

            if (newRank < 0 || newRank >= Board.SIZE || newFile < 0 || newFile >= Board.SIZE) {
                continue;
            }

            Piece piece = board.getRank(newRank).get(newFile);
            if (piece.getColor() == this.color) {
                continue;
            }

            validMoves.add(new Position(newRank, newFile));
        }
        return validMoves;
    }
}
