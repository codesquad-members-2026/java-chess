package com.codesquad.chess;

import com.codesquad.chess.pieces.Piece;
import com.codesquad.chess.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Rank> ranks = new ArrayList<>();

    public void initialize() {
        ranks.clear(); // 기존 데이터 초기화
        for (int i = 0; i < 8; i++) {
            ranks.add(new Rank());
        }

        // 인덱스 0~7 순서대로 체스판 배치 (0이 검은색 진영, 7이 흰색 진영 기준)
        setupBlackPieces(ranks.get(0));
        setupBlackPawns(ranks.get(1));

        for (int i = 2; i < 6; i++) {
            setupBlankRank(ranks.get(i));
        }

        setupWhitePawns(ranks.get(6));
        setupWhitePieces(ranks.get(7));
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

    private void setupBlankRank(Rank rank) {
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

    public int size() {
        int totalSize = 0;
        for (Rank rank : ranks) {
            // 빈 칸(Blank)을 제외한 기물들의 개수만 합산
            totalSize += rank.getPieceCountWithoutBlank();
        }
        return totalSize;
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : ranks) {
            sb.append(rank.getRankRepresentation()).append(StringUtils.NEWLINE);
        }
        return sb.toString();
    }
}