package chess.pieces;

import chess.Board;
import chess.Direction;
import chess.Position;
import java.util.List;

public class Knight extends Piece {
    protected Knight(Type type, Color color, Position position) {
        super(type, color, position);
    }

    @Override
    public List<Position> getValidMoves(Board board) {
        return List.of();
    }
}
