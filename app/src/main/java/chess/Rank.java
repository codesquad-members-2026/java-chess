package chess;

import static chess.pieces.Piece.Type.*;
import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import java.util.ArrayList;
import java.util.List;

public class Rank {
    private List<Piece> rank;
    private static final List<Type> type = List.of(ROOK, KNIGHT, BISHOP, QUEEN, KING, BISHOP, KING, ROOK);

    private Rank(List<Piece> rank) {
        this.rank = rank;
    }

    public static Rank fillWithMajorPieces(Color color, int rankNum) {
        List<Piece> rank = new ArrayList<>();
        for (int file = 0; file < 8; file++) {
            Position position = new Position(rankNum, file);
            rank.add(Piece.create(type.get(file), color, position));
        }
        return new Rank(rank);
    }

    public static Rank emptyRank(int rankNum) {
        List<Piece> rank = new ArrayList<>();
        for (int fileNum = 0; fileNum < Board.SIZE; fileNum++) {
            rank.add(null);
        }
        return new Rank(rank);
    }

    public static Rank fillWithPawns(Color color, int rankNum) {
        List<Piece> rank = new ArrayList<>();
        for (int file = 0; file < 8; file++) {
            Position position = new Position(rankNum, file);
            rank.add(Piece.create(PAWN, color, position));
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
