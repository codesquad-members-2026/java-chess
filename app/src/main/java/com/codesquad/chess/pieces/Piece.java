package com.codesquad.chess.pieces;

import com.codesquad.chess.Board;
import com.codesquad.chess.Position;

import java.util.Objects;

public class Piece implements Comparable<Piece> {
    public enum Color { WHITE, BLACK, NOCOLOR }
    public enum Type {
        PAWN('p', 1.0),
        ROOK('r', 5.0),
        KNIGHT('n', 2.5),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k', 0.0),
        NO_PIECE('.', 0.0);

        private final char representation;
        private final double defaultPoint;

        Type(char representation, double defaultPoint) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        public char getRepresentation() { return representation; }
        public double getDefaultPoint() { return defaultPoint; }
    }

    private final Color color;
    private final Type type;

    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public static Piece createWhitePawn() { return new Piece(Color.WHITE, Type.PAWN); }
    public static Piece createBlackPawn() { return new Piece(Color.BLACK, Type.PAWN); }
    public static Piece createWhiteRook() { return new Piece(Color.WHITE, Type.ROOK); }
    public static Piece createBlackRook() { return new Piece(Color.BLACK, Type.ROOK); }
    public static Piece createWhiteKnight() { return new Piece(Color.WHITE, Type.KNIGHT); }
    public static Piece createBlackKnight() { return new Piece(Color.BLACK, Type.KNIGHT); }
    public static Piece createWhiteBishop() { return new Piece(Color.WHITE, Type.BISHOP); }
    public static Piece createBlackBishop() { return new Piece(Color.BLACK, Type.BISHOP); }
    public static Piece createWhiteQueen() { return new Piece(Color.WHITE, Type.QUEEN); }
    public static Piece createBlackQueen() { return new Piece(Color.BLACK, Type.QUEEN); }
    public static Piece createWhiteKing() { return new Piece(Color.WHITE, Type.KING); }
    public static Piece createBlackKing() { return new Piece(Color.BLACK, Type.KING); }
    public static Piece createBlank() { return new Piece(Color.NOCOLOR, Type.NO_PIECE); }

    public Color getColor() { return color; }
    public Type getType() { return type; }

    public char getRepresentation() {
        if (color == Color.BLACK) return Character.toUpperCase(type.getRepresentation());
        return type.getRepresentation();
    }

    public double getPoint() { return type.getDefaultPoint(); }

    public boolean queenMoving(Position sourcePos, Position targetPos, Board board) {
        int queenX = targetPos.getX() - sourcePos.getX();
        int queenY = targetPos.getY() - sourcePos.getY();

        boolean isStraight = (queenX == 0 || queenY == 0);
        boolean isDiagonal = Math.abs(queenX) == Math.abs(queenY);

        if(!(isStraight || isDiagonal)) return false;

        int dirX = Integer.compare(targetPos.getX(), sourcePos.getX());
        int dirY = Integer.compare(targetPos.getY(), sourcePos.getY());

        return queenCanGo(sourcePos, targetPos, dirX, dirY, board) ;
    }
    public boolean queenCanGo(Position current, Position target, int dirX,
                              int dirY, Board board) {
        Position next = new Position(current.getX() + dirX, current.getY() + dirY);

        if(next.equals(target)) {
            return true;
        }

        if(board.findPiece(next).getType() != Type.NO_PIECE) {
            return false;
        }

        return queenCanGo(next, target, dirX, dirY, board);
    }

    @Override
    public int compareTo(Piece other) {
        return Double.compare(other.getPoint(), this.getPoint());
    }

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
}