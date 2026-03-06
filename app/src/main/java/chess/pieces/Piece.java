package chess.pieces;

import chess.Direction;
import chess.Position;
import java.util.List;

public interface Piece {
    enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    enum Type {
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

        char getWhiteRepresentation() {
            return representation;
        }

        char getBlackRepresentation() {
            return (char) (representation + BLACK_OFFSET);
        }

        public double getDefaultPoint() {
            return defaultPoint;
        }
    }

    static Piece create(Type type, Color color, Position position) {
        return switch (type) {
            case KING -> new King(color, position);
            case QUEEN -> new Queen(color,position);
            case PAWN -> new Pawn(color, position);
            case ROOK -> new Rook(color, position);
            case BISHOP -> new Bishop(color,position);
            case KNIGHT -> new Knight(color, position);
            case NO_PIECE -> null;
        };
    }

    Color getColor();
    Type getType();
    void move();
    List<Direction> getDirections();
}
