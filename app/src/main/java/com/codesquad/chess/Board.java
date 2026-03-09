package com.codesquad.chess;
<<<<<<< HEAD
import com.codesquad.chess.pieces.Piece;
import com.codesquad.chess.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;


public class Board {

    private List<Rank> ranks = new ArrayList<>();
    public static final int SIZE = 8;

    public void initialize() {
        for (int i = 0; i < SIZE; i++) {
            ranks.add(new Rank());
        }
        setupBlackPieces(ranks.get(0));
        setupBlackPawns(ranks.get(1));

        for(int i = 2; i < 6; i++) {
            setupBlanckRank(ranks.get(i));
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
        for (int i = 0; i < SIZE; i++) {
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
        for (int i = 0; i < SIZE; i++) {
            rank.addPiece(Piece.createWhitePawn());
        }
    }

    private void setupBlanckRank(Rank rank) {
        for (int i = 0; i < SIZE; i++) {
            rank.addPiece(Piece.createBlank());
        }
    }

    public int countPiece(Piece.Color color, Piece.Type type) {
        int count = 0;
        for (Rank rank : ranks) {
            count += rank.getPieceCount(color, type);
        }
        return count;
=======
import java.util.ArrayList;
import java.util.List;
import pieces.Pawn;

public class Board {

    private List<Pawn> whitePawns = new ArrayList<>();
    private List<Pawn> blackPawns = new ArrayList<>();

    public void initialize() {
        whitePawns.clear();
        blackPawns.clear();

        for (int i = 0; i < 8; i++) {
            whitePawns.add(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
            blackPawns.add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        }
>>>>>>> upstream/Hana
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
<<<<<<< HEAD
        for (Rank rank : ranks) {
            sb.append(rank.getRankRepresentation()).append(StringUtils.NEWLINE);
=======
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
>>>>>>> upstream/Hana
        }
        return sb.toString();
    }

<<<<<<< HEAD
    public Piece findPiece(String positonStr) {
        Position position = new Position(positonStr);

        Rank rank = ranks.get(position.getY());
        return rank.getPiece(position.getX());
    }

    public void initializeEmpty() {
        ranks.clear();

        for(int i = 0; i < SIZE; i++) {
            Rank rank = new Rank();

            for(int j = 0; j < SIZE; j++) {
                rank.addPiece(Piece.createBlank());
            }
            ranks.add(rank);
        }
    }

    public void move(String positionStr, Piece piece) {
        Position position = new Position(positionStr);

        Rank targetRank = ranks.get(position.getY());

        targetRank.setPiece(position.getX(), piece);
    }

    public double calculatePoint(Piece.Color color) {
        double totalPoint = 0;

        for (Rank rank : ranks) {
            for (int i = 0; i < SIZE; i++) {
                Piece piece = rank.getPiece(i);
                if (piece.getColor() == color) {
                    totalPoint += piece.getPoint();
                }
            }
        }
        for (int x = 0; x < SIZE; x++) {
            int pawnCount = 0;
            for (int y = 0; y < SIZE; y++) {

                Piece piece = ranks.get(y).getPiece(x);
                if (piece.getColor() == color && piece.getType() == Piece.Type.PAWN) {
                    pawnCount++;
                }
            }
            if (pawnCount > 1) {
                totalPoint -= (pawnCount * 0.5);
            }
        }
        return totalPoint;
=======
    public int size() {
        // 흰색 폰 8개 + 검은색 폰 8개 = 총 16개가 나오도록 합쳐줍니다.
        return whitePawns.size() + blackPawns.size();
>>>>>>> upstream/Hana
    }
}