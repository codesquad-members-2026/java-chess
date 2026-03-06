package chess.pieces;

import static chess.pieces.Piece.Color.*;
import static chess.pieces.Piece.Type.*;

import chess.Position;
import java.util.Comparator;
import java.util.Objects;

public class Piece implements Comparable<Piece>{
    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        QUEEN('♕', 9.0),
        ROOK('♖', 5.0),
        BISHOP('♗', 3.0),
        KNIGHT('♘', 2.5),
        PAWN('♙', 1.0),
        KING('♔', 0.0),
        NO_PIECE('.', 0.0);

        private static final int BLACK_OFFSET = '♟' - '♙';

        private char representation;
        private double defaultPoint;

        Type(char representation, double defaultPoint) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        char getWhiteRepresentation() {
            return representation;
        }

        char getBlackRepresentation() {
            return (char) (representation + BLACK_OFFSET);
        }

        public double getDefaultPoint() {
            return defaultPoint;
        }
    }

    private final Color color;
    private final Type type;
    private Position position;


    private Piece(Color color, Type type, Position position) {
        this.color = color;
        this.type = type;
        this.position = position;
    }

    private static Piece createWhite(Type type,Position position) {
        return new Piece(WHITE, type, position);
    }

    private static Piece createBlack(Type type,Position position) {
        return new Piece(BLACK, type, position);
    }

    public static Piece createWhitePawn(Position position) {
        return createWhite(PAWN, position);
    }

    public static Piece createBlackPawn(Position position) {
        return createBlack(PAWN, position);
    }

    public static Piece createWhiteKnight(Position position) {
        return createWhite(KNIGHT, position);
    }

    public static Piece createBlackKnight(Position position) {
        return createBlack(KNIGHT, position);
    }

    public static Piece createWhiteRook(Position position) {
        return createWhite(ROOK, position);
    }

    public static Piece createBlackRook(Position position) {
        return createBlack(ROOK, position);
    }

    public static Piece createWhiteBishop(Position position) {
        return createWhite(BISHOP, position);
    }

    public static Piece createBlackBishop(Position position) {
        return createBlack(BISHOP, position);
    }

    public static Piece createWhiteQueen(Position position) {
        return createWhite(QUEEN,position);
    }

    public static Piece createBlackQueen(Position position) {
        return createBlack(QUEEN,position);
    }

    public static Piece createWhiteKing(Position position) {
        return createWhite(KING,position);
    }

    public static Piece createBlackKing(Position position) {
        return createBlack(KING,position);
    }

    public static Piece createBlank(Position position) {
        return new Piece(NOCOLOR, NO_PIECE, position);
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public char getRepresentation() {
        if (color == BLACK) {
            return type.getBlackRepresentation();
        } else {
            return type.getWhiteRepresentation();
        }
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isWhite() {
        return color == WHITE;
    }

    public boolean isMatch(Color color, Type type) {
        return this.color == color && this.type == type;
    }

    public void move(Position position) {
        this.position = position;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Piece piece = (Piece) o;
        return isMatch(piece.color, piece.type) && position.equals(piece.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, position);
    }

    @Override
    public int compareTo(Piece o) {
        return Comparator.comparing(Piece::getColor)
                .thenComparing(Piece::getType)
                .compare(this, o);
    }
}
