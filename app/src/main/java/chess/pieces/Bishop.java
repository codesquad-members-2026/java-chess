package chess.pieces;

import chess.Board;
import chess.Position;
import java.util.List;

public class Bishop extends Piece {
    protected Bishop(Type type, Color color, Position position) {
        super(type, color, position);
    }
    @Override
    public List<Position> getValidMoves(Board board) {
        return List.of();
    }
}
