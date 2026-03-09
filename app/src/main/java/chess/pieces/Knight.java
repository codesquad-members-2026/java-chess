package chess.pieces;

import chess.Board;
import chess.Direction;
import chess.Position;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Knight extends Piece {
    protected Knight(Type type, Color color) {
        super(type, color);
    }

    @Override
    public Set<Position> getValidMoves(Position from, Board board) {
        return steppingMoves(from, board, Direction.knightDirection());
    }
}
