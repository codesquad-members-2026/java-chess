package com.codesquad.chess.pieces;

public class Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";

    // 기물별 대표 문자 (상수)
    public static final char WHITE_PAWN = 'p';
    public static final char BLACK_PAWN = 'P';
    public static final char WHITE_KNIGHT = 'n';
    public static final char BLACK_KNIGHT = 'N';
    public static final char WHITE_ROOK = 'r';
    public static final char BLACK_ROOK = 'R';
    public static final char WHITE_BISHOP = 'b';
    public static final char BLACK_BISHOP = 'B';
    public static final char WHITE_QUEEN = 'q';
    public static final char BLACK_QUEEN = 'Q';
    public static final char WHITE_KING = 'k';
    public static final char BLACK_KING = 'K';

    private final String color;
    private final char representation;

    private Piece(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn() { return new Piece(WHITE_COLOR, WHITE_PAWN); }
    public static Piece createBlackPawn() { return new Piece(BLACK_COLOR, BLACK_PAWN); }
    public static Piece createWhiteKnight() { return new Piece(WHITE_COLOR, WHITE_KNIGHT); }
    public static Piece createBlackKnight() { return new Piece(BLACK_COLOR, BLACK_KNIGHT); }
    public static Piece createWhiteRook() { return new Piece(WHITE_COLOR, WHITE_ROOK); }
    public static Piece createBlackRook() { return new Piece(BLACK_COLOR, BLACK_ROOK); }
    public static Piece createWhiteBishop() { return new Piece(WHITE_COLOR, WHITE_BISHOP); }
    public static Piece createBlackBishop() { return new Piece(BLACK_COLOR, BLACK_BISHOP); }
    public static Piece createWhiteQueen() { return new Piece(WHITE_COLOR, WHITE_QUEEN); }
    public static Piece createBlackQueen() { return new Piece(BLACK_COLOR, BLACK_QUEEN); }
    public static Piece createWhiteKing() { return new Piece(WHITE_COLOR, WHITE_KING); }
    public static Piece createBlackKing() { return new Piece(BLACK_COLOR, BLACK_KING); }

    public boolean isWhite() {
        return WHITE_COLOR.equals(this.color);
    }
    public boolean isBlack() {
        return BLACK_COLOR.equals(this.color);
    }

    public String getColor() {
        return color;
    }
    public char getRepresentation() {
        return representation;
    }
}