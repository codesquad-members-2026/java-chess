package chess.pieces;

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
