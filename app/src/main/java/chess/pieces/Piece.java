package chess.pieces;

import static chess.pieces.Piece.Color.*;
import static chess.pieces.Piece.Type.*;

public class Piece {
    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('♙'),
        ROOK('♖'),
        KNIGHT('♘'),
        BISHOP('♗'),
        QUEEN('♕'),
        KING('♔'),
        NO_PIECE('.');

        private static final int BLACK_OFFSET = '♟' - '♙';;
        private char representation;

        Type(char representation) {
            this.representation = representation;
        }

        char getWhiteRepresentation() {
            return representation;
        }

        char getBlackRepresentation() {
            return (char) (representation + BLACK_OFFSET);
        }
    }

    private final Color color;
    private final Type type;


    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public static Piece createWhitePawn() {
        return new Piece(WHITE, Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(BLACK, PAWN);
    }

    public static Piece createWhiteKnight() {
        return new Piece(WHITE, KNIGHT);
    }

    public static Piece createBlackKnight() {
        return new Piece(BLACK, KNIGHT);
    }

    public static Piece createWhiteRook() {
        return new Piece(WHITE, ROOK);
    }

    public static Piece createBlackRook() {
        return new Piece(BLACK, ROOK);

    }

    public static Piece createWhiteBishop() {
        return new Piece(WHITE, BISHOP);

    }

    public static Piece createBlackBishop() {
        return new Piece(BLACK, BISHOP);
    }

    public static Piece createWhiteQueen() {
        return new Piece(WHITE, QUEEN);
    }

    public static Piece createBlackQueen() {
        return new Piece(BLACK, QUEEN);
    }

    public static Piece createWhiteKing() {
        return new Piece(WHITE, KING);
    }

    public static Piece createBlackKing() {
        return new Piece(BLACK, KING);
    }

    public static Piece createBlank() {
        return new Piece(NOCOLOR, NO_PIECE);
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public char getRepresentation() {
        if (color == BLACK) {
            return type.getBlackRepresentation();
        } else {
            return type.getWhiteRepresentation();
        }
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }
    public boolean isWhite() {
        return color == WHITE;
    }
}
