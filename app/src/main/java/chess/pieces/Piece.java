package chess.pieces;

public class Piece {
    public static final String PAWN = "pawn";
    public static final String KNIGHT = "knight";
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char WHITE_PAWN_REPRESENTATION = '♙';
    public static final char BLACK_PAWN_REPRESENTATION = '♟';
    public static final char WHITE_KNIGHT_REPRESENTATION = '♘';
    public static final char BLACK_KNIGHT_REPRESENTATION = '♞';

    private final String color;
    private final String name;
    private final char representation;


    private Piece(String color, String name, char representation) {
        this.color = color;
        this.name = name;
        this.representation = representation;

    }

    public static Piece createWhitePawn() {
        return new Piece(WHITE_COLOR, PAWN, WHITE_PAWN_REPRESENTATION);
    }

    public static Piece createBlackPawn() {
        return new Piece(BLACK_COLOR, PAWN, BLACK_PAWN_REPRESENTATION);
    }

    public static Piece createWhiteKnight() {
        return new Piece(WHITE_COLOR, KNIGHT, WHITE_KNIGHT_REPRESENTATION);
    }

    public static Piece createBlackKnight() {
        return new Piece(BLACK_COLOR, KNIGHT, BLACK_KNIGHT_REPRESENTATION);
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
