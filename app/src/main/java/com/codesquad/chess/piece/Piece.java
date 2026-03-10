package com.codesquad.chess.piece;

import com.codesquad.chess.Position;
import java.util.Objects;

public class Piece {
    private final Color color;
    private final char representation;
    private final double point;
    private Position position;

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

    private Piece(Color color, char representation, double point, Position position) {
        this.color = color;
        this.representation = representation;
        this.point = point;
        this.position = position;
    }

    private static Piece createWhite(Type type, Position position){
        return new Piece(Color.WHITE, type.getWhiteRepresentation(), type.getPoint(), position);
    }
    private static Piece createBlack(Type type, Position position){
        return new Piece(Color.BLACK, type.getBlackRepresentation(), type.getPoint(), position);
    }
    public static Piece createBlank(Position position){
        return new Piece(Color.NOCOLOR, Type.NO_PIECE.getWhiteRepresentation(), Type.NO_PIECE.getPoint(), position);
    }

    public static Piece createWhitePawn(Position position){
        return createWhite(Type.PAWN, position);
    }
    public static Piece createWhiteKing(Position position){
        return createWhite(Type.KING, position);
    }
    public static Piece createWhiteQueen(Position position){
        return createWhite(Type.QUEEN, position);
    }
    public static Piece createWhiteRook(Position position){
        return createWhite(Type.ROOK, position);
    }
    public static Piece createWhiteKnight(Position position){
        return createWhite(Type.KNIGHT, position);
    }
    public static Piece createWhiteBishop(Position position){
        return createWhite(Type.BISHOP, position);
    }

    public static Piece createBlackPawn(Position position){
        return createBlack(Type.PAWN, position);
    }
    public static Piece createBlackKing(Position position){
        return createBlack(Type.KING, position);
    }
    public static Piece createBlackQueen(Position position){
        return createBlack(Type.QUEEN, position);
    }
    public static Piece createBlackRook(Position position){
        return createBlack(Type.ROOK, position);
    }
    public static Piece createBlackKnight(Position position){
        return createBlack(Type.KNIGHT, position);
    }
    public static Piece createBlackBishop(Position position){
        return createBlack(Type.BISHOP, position);
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
    public Position getPosition() {
        return position;
    }

    public boolean isWhite() {
        return color.equals(Color.WHITE);
    }
    public boolean isBlack() {
        return color.equals(Color.BLACK);
    }
    public void changePosition(Position position){
        this.position = position;
    }

    @Override
    public String toString() {
        return "[기물 종류: " + getRepresentation() + " | 기물 색깔: " + getColor() + "]";
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
