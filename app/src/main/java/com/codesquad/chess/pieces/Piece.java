package com.codesquad.chess.pieces;

import java.util.Objects;

public class Piece implements Comparable<Piece> {

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('p', 1.0),
        ROOK('r', 5.0),
        KNIGHT('n', 2.5),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k', 0.0),
        NO_PIECE('.', 0.0);

        private char representation;
        private double defaultPoint;

        Type(char representation, double defaultPoint) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        public double getDefaultPoint() {
            return defaultPoint;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return color == piece.color && type == piece.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }

    public char getRepresentation() {
        if (isBlack()) {
            return type.getBlackRepresentaiton();
        }
        return type.getWhiteRepresentation();
    }

    public double getPoint() {
        return type.getDefaultPoint();
    }
    @Override
    public int compareTo(Piece other) {
        return Double.compare(other.getPoint(), this.getPoint());
    }
}