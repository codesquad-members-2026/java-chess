package chess.pieces;


import chess.Board;
import chess.Position;
import java.util.List;

public class Blank extends Piece {
    public static Blank blank = new Blank();

    private Blank() {
        super(Type.NO_PIECE, Color.NOCOLOR, null);
    }

    public static Blank getBlank() {
        return blank;
    }

    @Override
    public List<Position> getValidMoves(Board board) {
        throw new IllegalStateException();
    }
}
