package com.codesquad.chess.pieces;
import com.codesquad.chess.*;

import java.util.Objects;

public abstract class Piece {

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

    protected Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public static Piece createWhiteQueen() {return new Queen(Color.WHITE);}
    public static Piece createBlackQueen() {return new Queen(Color.BLACK);}
    public static Piece createWhiteKing() {return new King(Color.WHITE);}
    public static Piece createBlackKing() {return new King(Color.BLACK);}
    public static Piece createBlank() {return new Blank();}
    public static Piece createWhitePawn() {return new Pawn(Color.WHITE);}
    public static Piece createBlackPawn() {return new Pawn(Color.BLACK);}

    public static Piece createWhiteRook() {return new Rook(Color.WHITE);}
    public static Piece createBlackRook() {return new Rook(Color.BLACK);}
    public static Piece createWhiteBishop() {return new Bishop(Color.WHITE);}
    public static Piece createBlackBishop() {return new Bishop(Color.BLACK);}
    public static Piece createWhiteKnight() {return new Knight(Color.WHITE);}
    public static Piece createBlackKnight() {return new Knight(Color.BLACK);}


    public Color getColor() { return color; }
    public Type getType() { return type; }

    public char getRepresentation() {
        if (color == Color.BLACK) return Character.toUpperCase(type.getRepresentation());
        return type.getRepresentation();
    }

    public abstract boolean canMove(Position sourcePos, Position targetPos, Board board);


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Piece)) return false;
        Piece piece = (Piece) o;
        return color == piece.color && type == piece.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }
}