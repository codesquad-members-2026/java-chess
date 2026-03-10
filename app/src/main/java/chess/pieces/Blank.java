package chess.pieces;


import chess.Board;
import chess.Position;
import java.util.Set;

public class Blank extends Piece {
    public static Blank blank = new Blank();

    private Blank() {
        super(Type.NO_PIECE, Color.NOCOLOR);
    }

    public static Blank getBlank() {
        return blank;
    }

    @Override
    public Set<Position> getValidMoves(Position from, Board board) {
        return Set.of();
    }
}
