package com.codesquad.chess.piece;

import java.util.Objects;

import static com.codesquad.chess.utils.ChessConstant.*;

public class Piece {
    private final String color;
    private final char representation;

    public enum Color{
        WHITE("white"),
        BLACK("black"),
        NOCOLOR("no");

        private String color;

        Color(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }

    public enum Type{
        PAWN('p'),
        ROOK('r'),
        KNIGHT('n'),
        BISHOP('b'),
        QUEEN('q'),
        KING('k'),
        NO_PIECE('.');

        private char representation;

        Type(char representation){
            this.representation = representation;
        }

        public char getWhiteRepresentation(){
            return representation;
        }

        public char getBlackRepresentation(){
            return Character.toUpperCase(representation);
        }
    }

    private Piece(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn(){
        return new Piece(Color.WHITE.getColor(), Type.PAWN.getWhiteRepresentation());
    }

    public static Piece createBlackPawn(){
        return new Piece(Color.BLACK.getColor(), Type.PAWN.getBlackRepresentation());
    }

    public static Piece createWhiteKing(){
        return new Piece(Color.WHITE.getColor(), Type.KING.getWhiteRepresentation());
    }

    public static Piece createBlackKing(){
        return new Piece(Color.BLACK.getColor(), Type.KING.getBlackRepresentation());
    }

    public static Piece createWhiteQueen(){
        return new Piece(Color.WHITE.getColor(), Type.QUEEN.getWhiteRepresentation());
    }

    public static Piece createBlackQueen(){
        return new Piece(Color.BLACK.getColor(), Type.QUEEN.getBlackRepresentation());
    }

    public static Piece createWhiteRook(){
        return new Piece(Color.WHITE.getColor(), Type.ROOK.getWhiteRepresentation());
    }

    public static Piece createBlackRook(){
        return new Piece(Color.BLACK.getColor(), Type.ROOK.getBlackRepresentation());
    }

    public static Piece createWhiteKnight(){
        return new Piece(Color.WHITE.getColor(), Type.KNIGHT.getWhiteRepresentation());
    }

    public static Piece createBlackKnight(){
        return new Piece(Color.BLACK.getColor(), Type.KNIGHT.getBlackRepresentation());
    }

    public static Piece createWhiteBishop(){
        return new Piece(Color.WHITE.getColor(), Type.BISHOP.getWhiteRepresentation());
    }

    public static Piece createBlackBishop(){
        return new Piece(Color.BLACK.getColor(), Type.BISHOP.getBlackRepresentation());
    }

    public static Piece createBlank(){
        return new Piece(Color.NOCOLOR.getColor(), Type.NO_PIECE.representation);
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public Type getType(){
        for(Type t : Type.values()){
            if(t.representation == Character.toLowerCase(representation))
                return t;
        }

        return null;
    }

    public boolean isWhite() {
        return color.equals(WHITE_COLOR);
    }

    public boolean isBlack() {
        return color.equals(BLACK_COLOR);
    }

    @Override
    public String toString() {
        return "[기물 종류]: " + getRepresentation() + ", [기물 색깔]: " + getColor();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj == null || obj.getClass() != this.getClass())
            return false;

        Piece other = (Piece) obj;
        return this.getColor().equals(other.getColor()) &&
                this.getRepresentation() == other.getRepresentation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, representation);
    }
}
