package com.codesquad.chess.piece;

import java.util.Objects;

public class Piece {
    private final Color color;
    private final char representation;
    private final double point;

    public enum Color{
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type{
        PAWN('p', 1.0),
        ROOK('r', 5.0),
        KNIGHT('n', 2.5),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k', 0.0),
        NO_PIECE('.', 0.0);

        private char representation;
        private double point;

        Type(char representation, double point){
            this.representation = representation;
            this.point = point;
        }

        public char getWhiteRepresentation(){
            return representation;
        }

        public char getBlackRepresentation(){
            return Character.toUpperCase(representation);
        }

        public double getPoint(){return point;}
    }

    private Piece(Color color, char representation, double point) {
        this.color = color;
        this.representation = representation;
        this.point = point;
    }

    private static Piece createWhite(Type type){
        return new Piece(Color.WHITE, type.getWhiteRepresentation(), type.getPoint());
    }
    private static Piece createBlack(Type type){
        return new Piece(Color.BLACK, type.getBlackRepresentation(), type.getPoint());
    }

    public static Piece createWhitePawn(){
        return createWhite(Type.PAWN);
    }
    public static Piece createWhiteKing(){
        return createWhite(Type.KING);
    }
    public static Piece createWhiteQueen(){
        return createWhite(Type.QUEEN);
    }
    public static Piece createWhiteRook(){
        return createWhite(Type.ROOK);
    }
    public static Piece createWhiteKnight(){
        return createWhite(Type.KNIGHT);
    }
    public static Piece createWhiteBishop(){
        return createWhite(Type.BISHOP);
    }

    public static Piece createBlackPawn(){
        return createBlack(Type.PAWN);
    }
    public static Piece createBlackKing(){
        return createBlack(Type.KING);
    }
    public static Piece createBlackQueen(){
        return createBlack(Type.QUEEN);
    }
    public static Piece createBlackRook(){
        return createBlack(Type.ROOK);
    }
    public static Piece createBlackKnight(){
        return createBlack(Type.KNIGHT);
    }
    public static Piece createBlackBishop(){
        return createBlack(Type.BISHOP);
    }
    public static Piece createBlank(){
        return new Piece(Color.NOCOLOR, Type.NO_PIECE.getWhiteRepresentation(), Type.NO_PIECE.getPoint());
    }

    public Color getColor() {
        return color;
    }
    public char getRepresentation() {
        return representation;
    }
    public double getPoint() {
        return point;
    }
    public Type getType(){
        Type type = Type.NO_PIECE;

        for(Type t : Type.values()){
            if(t.representation == Character.toLowerCase(representation))
                type = t;
        }

        return type;
    }
    public boolean isWhite() {
        return color.equals(Color.WHITE);
    }
    public boolean isBlack() {
        return color.equals(Color.BLACK);
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
