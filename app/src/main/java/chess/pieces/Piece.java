package chess.pieces;

import chess.Board;
import chess.Position;
import java.util.Set;

public abstract class Piece {
    public static Piece create(Type type, Color color, Position position) {
        return switch (type) {
            case KING -> new King(type, color);
            case QUEEN -> new Queen(type, color);
            case PAWN -> new Pawn(type, color);
            case ROOK -> new Rook(type, color);
            case BISHOP -> new Bishop(type, color);
            case KNIGHT -> new Knight(type, color);
            case NO_PIECE -> Blank.getBlank();
        };
    }

    protected Type type;
    protected final Color color;

    protected Piece(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public abstract Set<Position> getValidMoves(Board board);
}
