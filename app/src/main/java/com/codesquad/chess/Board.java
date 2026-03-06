package com.codesquad.chess;
import com.codesquad.chess.pieces.Piece;
import com.codesquad.chess.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;


public class Board {

    private List<Rank> ranks = new ArrayList<>();

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            ranks.add(new Rank());
        }
        setupBlackPieces(ranks.get(0));
        setupBlackPawns(ranks.get(1));

        for(int i = 2; i < 6; i++) {
            setupBlanckRank(ranks.get(i));
        }

        setupWhitePieces(ranks.get(6));
        setupWhitePawns(ranks.get(7));
    }

    private void setupBlackPieces(Rank rank) {
        rank.addPiece(Piece.createBlackRook());
        rank.addPiece(Piece.createBlackKnight());
        rank.addPiece(Piece.createBlackBishop());
        rank.addPiece(Piece.createBlackQueen());
        rank.addPiece(Piece.createBlackKing());
        rank.addPiece(Piece.createBlackBishop());
        rank.addPiece(Piece.createBlackKnight());
        rank.addPiece(Piece.createBlackRook());
    }

    private void setupBlackPawns(Rank rank) {
        for (int i = 0; i < 8; i++) {
            rank.addPiece(Piece.createBlackPawn());
        }
    }

    private void setupWhitePieces(Rank rank) {
        rank.addPiece(Piece.createWhiteRook());
        rank.addPiece(Piece.createWhiteKnight());
        rank.addPiece(Piece.createWhiteBishop());
        rank.addPiece(Piece.createWhiteQueen());
        rank.addPiece(Piece.createWhiteKing());
        rank.addPiece(Piece.createWhiteBishop());
        rank.addPiece(Piece.createWhiteKnight());
        rank.addPiece(Piece.createWhiteRook());
    }

    private void setupWhitePawns(Rank rank) {
        for (int i = 0; i < 8; i++) {
            rank.addPiece(Piece.createWhitePawn());
        }
    }

    private void setupBlanckRank(Rank rank) {
        for (int i = 0; i < 8; i++) {
            rank.addPiece(Piece.createBlank());
        }
    }

    public int countPiece(Piece.Color color, Piece.Type type) {
        int count = 0;
        for (Rank rank : ranks) {
            count += rank.getPieceCount(color, type);
        }
        return count;
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : ranks) {
            sb.append(rank.getRankRepresentation()).append(StringUtils.NEWLINE);
        }
        return sb.toString();
    }
}