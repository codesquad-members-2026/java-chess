package chess.pieces;

import chess.Board;
import chess.Position;
import java.util.Set;

public abstract class Piece {
    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        QUEEN('♕', 9.0),
        ROOK('♖', 5.0),
        BISHOP('♗', 3.0),
        KNIGHT('♘', 2.5),
        PAWN('♙', 1.0),
        KING('♔', 0.0),
        NO_PIECE('.', 0.0);

        private static final int BLACK_OFFSET = '♟' - '♙';

        private final char representation;
        private final double defaultPoint;

        Type(char representation, double defaultPoint) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        public char getRepresentation(Color color) {
            if (color == Color.BLACK) {
                return (char) (representation + BLACK_OFFSET);
            } else {
                return representation;
            }
        }

        public double getDefaultPoint() {
            return defaultPoint;
        }
    }

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
