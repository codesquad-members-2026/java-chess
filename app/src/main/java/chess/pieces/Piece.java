package chess.pieces;

import chess.Board;
import chess.Direction;
import chess.Position;
import java.util.List;

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

        private char representation;
        private double defaultPoint;

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
            case KING -> new King(type, color, position);
            case QUEEN -> new Queen(type, color,position);
            case PAWN -> new Pawn(type, color, position);
            case ROOK -> new Rook(type, color, position);
            case BISHOP -> new Bishop(type, color,position);
            case KNIGHT -> new Knight(type, color, position);
            case NO_PIECE -> Blank.getBlank();
        };
    }

    protected Type type;
    protected final Color color;
    protected Position position;

    protected Piece(Type type, Color color, Position position) {
        this.type = type;
        this.color = color;
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public abstract List<Position> getValidMoves(Board board);

    public void move(Position position) {
        this.position = position;
    }
}
