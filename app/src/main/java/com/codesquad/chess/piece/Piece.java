package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.Position;
import java.util.Objects;

public abstract class Piece {
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

    protected Piece(Color color, char representation, double point, Position position) {
        this.color = color;
        this.representation = representation;
        this.point = point;
        this.position = position;
    }

    public static Piece createWhitePawn(Position position){
        return new Pawn(Color.WHITE, Type.PAWN.getWhiteRepresentation(), Type.PAWN.getPoint(), position);
    }
    public static Piece createWhiteKing(Position position){
        return new King(Color.WHITE, Type.KING.getWhiteRepresentation(), Type.KING.getPoint(), position);
    }
    public static Piece createWhiteQueen(Position position){
        return new Queen(Color.WHITE, Type.QUEEN.getWhiteRepresentation(), Type.QUEEN.getPoint(), position);
    }
    public static Piece createWhiteRook(Position position){
        return new Rook(Color.WHITE, Type.ROOK.getWhiteRepresentation(), Type.ROOK.getPoint(), position);
    }
    public static Piece createWhiteKnight(Position position){
        return new Knight(Color.WHITE, Type.KNIGHT.getWhiteRepresentation(), Type.KNIGHT.getPoint(), position);
    }
    public static Piece createWhiteBishop(Position position){
        return new Bishop(Color.WHITE, Type.BISHOP.getWhiteRepresentation(), Type.BISHOP.getPoint(), position);
    }

    public static Piece createBlackPawn(Position position){
        return new Pawn(Color.BLACK, Type.PAWN.getBlackRepresentation(), Type.PAWN.getPoint(), position);
    }
    public static Piece createBlackKing(Position position){
        return new King(Color.BLACK, Type.KING.getBlackRepresentation(), Type.KING.getPoint(), position);
    }
    public static Piece createBlackQueen(Position position){
        return new Queen(Color.BLACK, Type.QUEEN.getBlackRepresentation(), Type.QUEEN.getPoint(), position);
    }
    public static Piece createBlackRook(Position position){
        return new Rook(Color.BLACK, Type.ROOK.getBlackRepresentation(), Type.ROOK.getPoint(), position);
    }
    public static Piece createBlackKnight(Position position){
        return new Knight(Color.BLACK, Type.KNIGHT.getBlackRepresentation(), Type.KNIGHT.getPoint(), position);
    }
    public static Piece createBlackBishop(Position position){
        return new Bishop(Color.BLACK, Type.BISHOP.getBlackRepresentation(), Type.BISHOP.getPoint(), position);
    }

    public static Piece createBlank(Position position){
        return new Blank(Color.NOCOLOR, Type.NO_PIECE.getBlackRepresentation(), Type.NO_PIECE.getPoint(), position);
    }

    public Color getColor() {
        return color;
    }
    public char getRepresentation() {
        return representation;
    }
    public Position getPosition() {
        return position;
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
    public void changePosition(Position position){
        this.position = position;
    }

    public abstract boolean verifyMovePosition(Position target, Board board);

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
