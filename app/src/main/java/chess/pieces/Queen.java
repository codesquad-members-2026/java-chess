package chess.pieces;

import chess.Direction;
import chess.Position;
import java.util.List;

public class Queen implements Piece {
    public Queen(Color color, Position position) {

    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public Type getType() {
        return Type.QUEEN;
    }

    @Override
    public void move(Position position) {

    }

    @Override
    public List<Direction> getDirections() {
        return List.of();
    }
}
