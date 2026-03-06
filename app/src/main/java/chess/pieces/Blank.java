package chess.pieces;

import chess.Direction;
import chess.Position;
import java.util.List;

public class Blank implements Piece {
    public static Blank blank = new Blank();

    private Blank() {
    }

    public static Blank getBlank() {
        return blank;
    }
    @Override
    public Color getColor() {
        return Color.NOCOLOR;
    }

    @Override
    public Type getType() {
        return Type.NO_PIECE;
    }

    @Override
    public void move(Position position) {

    }

    @Override
    public List<Direction> getDirections() {
        return null;
    }
}
