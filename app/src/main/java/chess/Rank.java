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

    public static Rank fillWithWhiteMajorPieces() {
        List<Piece> rank = new ArrayList<>();
        rank.add(Piece.createWhiteRook());
        rank.add(Piece.createWhiteKnight());
        rank.add(Piece.createWhiteBishop());
        rank.add(Piece.createWhiteQueen());
        rank.add(Piece.createWhiteKing());
        rank.add(Piece.createWhiteBishop());
        rank.add(Piece.createWhiteKnight());
        rank.add(Piece.createWhiteRook());
        return new Rank(rank);
    }

    public static Rank fillWithBlackMajorPieces() {
        List<Piece> rank = new ArrayList<>();
        rank.add(Piece.createBlackRook());
        rank.add(Piece.createBlackKnight());
        rank.add(Piece.createBlackBishop());
        rank.add(Piece.createBlackQueen());
        rank.add(Piece.createBlackKing());
        rank.add(Piece.createBlackBishop());
        rank.add(Piece.createBlackKnight());
        rank.add(Piece.createBlackRook());
        return new Rank(rank);
    }

    public static Rank emptyRank() {
        List<Piece> rank = new ArrayList<>();
        for (int i = 0; i < Board.SIZE; i++) {
            rank.add(Piece.createBlank());
        }
        return new Rank(rank);
    }

    public static Rank fillWithWhitePawns() {
        List<Piece> rank = new ArrayList<>();
        for (int i = 0; i < Board.SIZE; i++) {
            rank.add(Piece.createWhitePawn());
        }
        return new Rank(rank);
    }

    public static Rank fillWithBlackPawns() {
        List<Piece> rank = new ArrayList<>();
        for (int i = 0; i < Board.SIZE; i++) {
            rank.add(Piece.createBlackPawn());
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
}
