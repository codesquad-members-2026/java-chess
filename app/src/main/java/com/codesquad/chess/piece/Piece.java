package com.codesquad.chess.piece;

import static com.codesquad.chess.ChessConstant.*;

public class Piece {
    private final String color;
    private final String representation;

    private Piece(String color, String representation) {
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn(){
        return new Piece(WHITE_COLOR, WHITE_CHESS_PAWN);
    }

    public static Piece createBlackPawn(){
        return new Piece(BLACK_COLOR, BLACK_CHESS_PAWN);
    }

    public static Piece createWhiteKing(){
        return new Piece(WHITE_COLOR, WHITE_CHESS_KING);
    }

    public static Piece createBlackKing(){
        return new Piece(BLACK_COLOR, BLACK_CHESS_KING);
    }

    public static Piece createWhiteQueen(){
        return new Piece(WHITE_COLOR, WHITE_CHESS_QUEEN);
    }

    public static Piece createBlackQueen(){
        return new Piece(BLACK_COLOR, BLACK_CHESS_QUEEN);
    }

    public static Piece createWhiteRook(){
        return new Piece(WHITE_COLOR, WHITE_CHESS_ROOK);
    }

    public static Piece createBlackRook(){
        return new Piece(BLACK_COLOR, BLACK_CHESS_ROOK);
    }

    public static Piece createWhiteKnight(){
        return new Piece(WHITE_COLOR, WHITE_CHESS_KNIGHT);
    }

    public static Piece createBlackKnight(){
        return new Piece(BLACK_COLOR, BLACK_CHESS_KNIGHT);
    }

    public static Piece createWhiteBishop(){
        return new Piece(WHITE_COLOR, WHITE_CHESS_BISHOP);
    }

    public static Piece createBlackBishop(){
        return new Piece(BLACK_COLOR, BLACK_CHESS_BISHOP);
    }

    public String getColor() {
        return color;
    }

    public String getRepresentation() {
        return representation;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
