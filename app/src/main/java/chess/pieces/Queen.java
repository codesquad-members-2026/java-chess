package chess.pieces;

import chess.Board;
import chess.Direction;
import chess.Position;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Queen extends Piece {
    protected Queen(Type type, Color color) {
        super(type, color);
    }

    @Override
    public Set<Position> getValidMoves(Position from, Board board) {
        return slidingMoves(from, board, Direction.everyDirection());
    }
}
