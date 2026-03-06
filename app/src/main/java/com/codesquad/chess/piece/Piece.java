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

    private static Piece createWhite(Type type){
        return new Piece(Color.WHITE.getColor(), type.getWhiteRepresentation());
    }

    private static Piece createBlack(Type type){
        return new Piece(Color.BLACK.getColor(), type.getBlackRepresentation());
    }

    public static Piece createWhitePawn(){
        return createWhite(Type.PAWN);
    }

    public static Piece createBlackPawn(){
        return createBlack(Type.PAWN);
    }

    public static Piece createWhiteKing(){
        return createWhite(Type.KING);
    }

    public static Piece createBlackKing(){
        return createBlack(Type.KING);
    }

    public static Piece createWhiteQueen(){
        return createWhite(Type.QUEEN);
    }

    public static Piece createBlackQueen(){
        return createBlack(Type.QUEEN);
    }

    public static Piece createWhiteRook(){
        return createWhite(Type.ROOK);
    }

    public static Piece createBlackRook(){
        return createBlack(Type.ROOK);
    }

    public static Piece createWhiteKnight(){
        return createWhite(Type.KNIGHT);
    }

    public static Piece createBlackKnight(){
        return createBlack(Type.KNIGHT);
    }

    public static Piece createWhiteBishop(){
        return createWhite(Type.BISHOP);
    }

    public static Piece createBlackBishop(){
        return createBlack(Type.BISHOP);
    }

    public static Piece createBlank(){
        return createWhite(Type.NO_PIECE);
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

        return Type.NO_PIECE;
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
