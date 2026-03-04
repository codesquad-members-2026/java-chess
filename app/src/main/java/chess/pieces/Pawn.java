package chess.pieces;

public class Pawn {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char WHITE_REPRESENTATION = '♙';
    public static final char BLACK_REPRESENTATION = '♟';

    private final String color;
    private final char representation;

    public Pawn() {
        this(WHITE_COLOR, WHITE_REPRESENTATION);
    }


    public Pawn(String color, char representation) {
        this.color = color;
        this.representation = representation;

    }
    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
