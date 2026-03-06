package com.codesquad.chess;
<<<<<<< HEAD
import com.codesquad.chess.pieces.Piece;
import com.codesquad.chess.utils.StringUtils;
=======
>>>>>>> upstream/Hana
import java.util.ArrayList;
import java.util.List;
import pieces.Pawn;


public class Board {

<<<<<<< HEAD
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
=======
    private List<Pawn> whitePawns = new ArrayList<>();
    private List<Pawn> blackPawns = new ArrayList<>();

    public void initialize() {
        whitePawns.clear();
        blackPawns.clear();

        for (int i = 0; i < 8; i++) {
            whitePawns.add(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
            blackPawns.add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        }
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        String blankLine = "........";
        String newLine = System.getProperty("line.separator");

        sb.append(blankLine).append(newLine);
        sb.append(getBlackPawnsResult()).append(newLine);
        sb.append(blankLine).append(newLine).append(blankLine).append(newLine);
        sb.append(blankLine).append(newLine).append(blankLine).append(newLine);
        sb.append(getWhitePawnsResult()).append(newLine);
        sb.append(blankLine).append(newLine);

        return sb.toString();
    }

    String getWhitePawnsResult() {
        return getPawnsResult(whitePawns);
    }

    String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }

    private String getPawnsResult(List<Pawn> pawns) {
        StringBuilder sb = new StringBuilder();
        for (Pawn pawn : pawns) {
            sb.append(pawn.getRepresentation());
        }
        return sb.toString();
    }

    public int size() {
        // 흰색 폰 8개 + 검은색 폰 8개 = 총 16개가 나오도록 합쳐줍니다.
        return whitePawns.size() + blackPawns.size();
    }
>>>>>>> upstream/Hana
}