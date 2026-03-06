package chess.pieces;

import chess.Direction;
import chess.Position;
import java.util.List;

public class King implements Piece{
    private final Color color;
    private final Position position;

    public King(Color color, Position position) {
        this.color = color;
        this.position = position;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Type getType() {
        return Type.KING;
    }

    @Override
    public void move() {
        //이동 로직
    }

    @Override
    public List<Direction> getDirections() {
        return Direction.everyDirection();
    }
}
