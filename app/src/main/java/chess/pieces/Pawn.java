package chess.pieces;

import chess.Board;
import chess.Position;
import java.util.List;
import java.util.Set;

public class Pawn extends Piece {
    protected Pawn(Type type, Color color) {
        super(type, color);
    }
    @Override
    public Set<Position> getValidMoves(Board board) {
        return Set.of();
    }
}
