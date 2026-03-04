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

    private static Piece createWhite(Type type) {
        return new Piece(WHITE, type);
    }

    private static Piece createBlack(Type type) {
        return new Piece(BLACK, type);
    }

    public static Piece createWhitePawn() {
        return createWhite(PAWN);
    }

    public static Piece createBlackPawn() {
        return createBlack(PAWN);
    }

    public static Piece createWhiteKnight() {
        return createWhite(KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createBlack(KNIGHT);
    }

    public static Piece createWhiteRook() {
        return createWhite(ROOK);
    }

    public static Piece createBlackRook() {
        return createBlack(ROOK);
    }

    public static Piece createWhiteBishop() {
        return createWhite(BISHOP);
    }

    public static Piece createBlackBishop() {
        return createBlack(BISHOP);
    }

    public static Piece createWhiteQueen() {
        return createWhite(QUEEN);
    }

    public static Piece createBlackQueen() {
        return createBlack(QUEEN);
    }

    public static Piece createWhiteKing() {
        return createWhite(KING);
    }

    public static Piece createBlackKing() {
        return createBlack(KING);
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
