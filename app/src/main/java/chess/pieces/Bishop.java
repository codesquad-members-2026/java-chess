package chess.pieces;

import chess.Board;
import chess.Direction;
import chess.Position;
import java.util.Set;

public class Bishop extends Piece {
    protected Bishop(Type type, Color color) {
        super(type, color);
    }
    @Override
    public Set<Position> getValidMoves(Position from, Board board) {
        return slidingMoves(from, board, Direction.diagonalDirection());
    }
}
