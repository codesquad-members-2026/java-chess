package chess;


import static chess.pieces.Type.*;

import chess.pieces.Blank;
import chess.pieces.Piece;
import chess.pieces.Color;
import chess.pieces.Type;
import java.util.ArrayList;
import java.util.List;

public class Rank {
    private static final List<Type> MAJOR_PIECES = List.of(ROOK, KNIGHT, BISHOP, QUEEN, KING, BISHOP, KNIGHT, ROOK);
    private List<Piece> rank;

    private Rank(List<Piece> rank) {
        this.rank = rank;
    }

    public static Rank fillWithMajorPieces(Color color) {
        List<Piece> rank = new ArrayList<>();
        for (int file = 0; file < 8; file++) {
            rank.add(Piece.create(MAJOR_PIECES.get(file), color));
        }
        return new Rank(rank);
    }

    public static Rank emptyRank() {
        List<Piece> rank = new ArrayList<>();
        for (int fileNum = 0; fileNum < Board.SIZE; fileNum++) {
            rank.add(Blank.getBlank());
        }
        return new Rank(rank);
    }

    public static Rank fillWithPawns(Color color) {
        List<Piece> rank = new ArrayList<>();
        for (int file = 0; file < 8; file++) {
            rank.add(Piece.create(PAWN, color));
        }
        return new Rank(rank);
    }

    public Piece getPiece(int file) {
        return rank.get(file);
    }

//    public int countPieces(Color color, Type type) {
//        int count = 0;
//        for (Piece piece : rank) {
//            if (piece.isMatch(color, type)) {
//                count++;
//            }
//        }
//        return count;
//    }

    public Piece get(int file) {
        return rank.get(file);
    }

    public void set(Piece piece, int file) {
        rank.set(file, piece);
    }
}
