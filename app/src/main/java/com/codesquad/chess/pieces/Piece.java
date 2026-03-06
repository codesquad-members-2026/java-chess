package com.codesquad.chess.pieces;

public class Piece {

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('p'), ROOK('r'), KNIGHT('n'), BISHOP('b'), QUEEN('q'), KING('k'), NO_PIECE('.');

        private char representation;

        Type(char representation) {
            this.representation = representation;
        }

        public char getWhiteRepresentation() {
            return representation;
        }

        public char getBlackRepresentaiton() {
            return Character.toUpperCase(representation);
        }

    }

    private final Color color;
    private final Type type;

    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    private static Piece createWhite(Type type) {
        return new Piece(Color.WHITE, type);
    }

    private static Piece createBlack(Type type) {
        return new Piece(Color.BLACK, type);
    }

    // 흰 말

    public static Piece createWhitePawn() { return createWhite(Type.PAWN); }
    public static Piece createWhiteRook() { return createWhite(Type.ROOK); }
    public static Piece createWhiteKnight() { return createWhite(Type.KNIGHT); }
    public static Piece createWhiteBishop() { return createWhite(Type.BISHOP); }
    public static Piece createWhiteQueen() { return createWhite(Type.QUEEN); }
    public static Piece createWhiteKing() { return createWhite(Type.KING); }

    // 검은 말

    public static Piece createBlackPawn() { return createBlack(Type.PAWN); }
    public static Piece createBlackRook() { return createBlack(Type.ROOK); }
    public static Piece createBlackKnight() { return createBlack(Type.KNIGHT); }
    public static Piece createBlackBishop() { return createBlack(Type.BISHOP); }
    public static Piece createBlackQueen() { return createBlack(Type.QUEEN); }
    public static Piece createBlackKing() { return createBlack(Type.KING); }


    // 빈 공간
    public static Piece createBlank() {
        return new Piece(Color.NOCOLOR, Type.NO_PIECE);
    }


    public boolean isWhite() { return this.color == Color.WHITE; }
    public boolean isBlack() { return this.color == Color.BLACK; }

    public Type getType() { return type; }
    public Color getColor() {return color;}

    public char getRepresentation() {
        if (isBlack()) {
            return type.getBlackRepresentaiton();
        }
        return type.getWhiteRepresentation();
    }
}