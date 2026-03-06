package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import java.util.ArrayList;
import java.util.List;

public class Rank {
    private List<Piece> rank;

    private Rank(List<Piece> rank) {
        this.rank = rank;
    }

    public static Rank fillWithWhiteMajorPieces(int rankNum) {
        List<Piece> rank = new ArrayList<>();
        rank.add(Piece.createWhiteRook(new Position(rankNum, 0)));
        rank.add(Piece.createWhiteKnight(new Position(rankNum, 1)));
        rank.add(Piece.createWhiteBishop(new Position(rankNum, 2)));
        rank.add(Piece.createWhiteQueen(new Position(rankNum, 3)));
        rank.add(Piece.createWhiteKing(new Position(rankNum, 4)));
        rank.add(Piece.createWhiteBishop(new Position(rankNum, 5)));
        rank.add(Piece.createWhiteKnight(new Position(rankNum, 6)));
        rank.add(Piece.createWhiteRook(new Position(rankNum, 7)));
        return new Rank(rank);
    }

    public static Rank fillWithBlackMajorPieces(int rankNum) {
        List<Piece> rank = new ArrayList<>();
        rank.add(Piece.createBlackRook(new Position(rankNum, 0)));
        rank.add(Piece.createBlackKnight(new Position(rankNum, 1)));
        rank.add(Piece.createBlackBishop(new Position(rankNum, 2)));
        rank.add(Piece.createBlackQueen(new Position(rankNum, 3)));
        rank.add(Piece.createBlackKing(new Position(rankNum, 4)));
        rank.add(Piece.createBlackBishop(new Position(rankNum, 5)));
        rank.add(Piece.createBlackKnight(new Position(rankNum, 6)));
        rank.add(Piece.createBlackRook(new Position(rankNum, 7)));
        return new Rank(rank);
    }

    public static Rank emptyRank(int rankNum) {
        List<Piece> rank = new ArrayList<>();
        for (int fileNum = 0; fileNum < Board.SIZE; fileNum++) {
            rank.add(Piece.createBlank(new Position(rankNum, fileNum)));
        }
        return new Rank(rank);
    }

    public static Rank fillWithWhitePawns(int rankNum) {
        List<Piece> rank = new ArrayList<>();
        for (int fileNum = 0; fileNum < Board.SIZE; fileNum++) {
            rank.add(Piece.createWhitePawn(new Position(rankNum, fileNum)));
        }
        return new Rank(rank);
    }

    public static Rank fillWithBlackPawns(int rankNum) {
        List<Piece> rank = new ArrayList<>();
        for (int fileNum = 0; fileNum < Board.SIZE; fileNum++) {
            rank.add(Piece.createBlackPawn(new Position(rankNum, fileNum)));
        }
        return new Rank(rank);
    }

    public String showRank() {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : rank) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

    public int countPieces(Color color, Type type) {
        int count = 0;
        for (Piece piece : rank) {
            if (piece.isMatch(color, type)) {
                count++;
            }
        }
        return count;
    }

    public Piece get(int file) {
        return rank.get(file);
    }

    public void set(Piece piece, int file) {
        rank.set(file, piece);
    }
}
