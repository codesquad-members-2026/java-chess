package com.codesquad.chess;

import com.codesquad.chess.pieces.Piece;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Rank> ranks = new ArrayList<>();
    public static final int SIZE = 8;

    public void initializeEmpty() {
        ranks.clear();
        for (int i = 0; i < SIZE; i++) {
            Rank rank = new Rank();
            for (int j = 0; j < SIZE; j++) {
                rank.addPiece(Piece.createBlank());
            }
            ranks.add(rank);
        }
    }

    public void move(String sourcePosition, String targetPosition) {
        Piece sourcePiece = findPiece(sourcePosition);

        Position targetPos = new Position(targetPosition);
        ranks.get(targetPos.getY()).setPiece(targetPos.getX(), sourcePiece);

        Position sourcePos = new Position(sourcePosition);
        ranks.get(sourcePos.getY()).setPiece(sourcePos.getX(), Piece.createBlank());
    }

    public Piece findPiece(String positionStr) {
        Position position = new Position(positionStr);
        return ranks.get(position.getY()).getPiece(position.getX());
    }

    public double calculatePoint(Piece.Color color) {
        double totalPoint = 0;
        for (Rank rank : ranks) {
            for (int i = 0; i < SIZE; i++) {
                Piece piece = rank.getPiece(i);
                if (piece.getColor() == color) totalPoint += piece.getPoint();
            }
        }

        for (int x = 0; x < SIZE; x++) {
            int pawnCount = 0;
            for (int y = 0; y < SIZE; y++) {
                Piece piece = ranks.get(y).getPiece(x);
                if (piece.getColor() == color && piece.getType() == Piece.Type.PAWN) pawnCount++;
            }
            if (pawnCount > 1) totalPoint -= (pawnCount * 0.5);
        }
        return totalPoint;
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : ranks) {
            sb.append(rank.getRankRepresentation()).append("\n");
        }
        return sb.toString();
    }

    public void initialize() {
        ranks.clear();

        ranks.add(createInitialRank(Piece.Color.BLACK));

        ranks.add(createPawnRank(Piece.Color.BLACK));

        for (int i = 0; i < 4; i++) {
            Rank emptyRank = new Rank();
            for (int j = 0; j < SIZE; j++) emptyRank.addPiece(Piece.createBlank());
            ranks.add(emptyRank);
        }

        ranks.add(createPawnRank(Piece.Color.WHITE));

        ranks.add(createInitialRank(Piece.Color.WHITE));
    }

    private Rank createInitialRank(Piece.Color color) {
        Rank rank = new Rank();
        if (color == Piece.Color.BLACK) {
            rank.addPiece(Piece.createBlackRook());
            rank.addPiece(Piece.createBlackKnight());
            rank.addPiece(Piece.createBlackBishop());
            rank.addPiece(Piece.createBlackQueen());
            rank.addPiece(Piece.createBlackKing());
            rank.addPiece(Piece.createBlackBishop());
            rank.addPiece(Piece.createBlackKnight());
            rank.addPiece(Piece.createBlackRook());
        } else {
            rank.addPiece(Piece.createWhiteRook());
            rank.addPiece(Piece.createWhiteKnight());
            rank.addPiece(Piece.createWhiteBishop());
            rank.addPiece(Piece.createWhiteQueen());
            rank.addPiece(Piece.createWhiteKing());
            rank.addPiece(Piece.createWhiteBishop());
            rank.addPiece(Piece.createWhiteKnight());
            rank.addPiece(Piece.createWhiteRook());
        }
        return rank;
    }

    private Rank createPawnRank(Piece.Color color) {
        Rank rank = new Rank();
        for (int i = 0; i < SIZE; i++) {
            rank.addPiece(color == Piece.Color.WHITE ? Piece.createWhitePawn() : Piece.createBlackPawn());
        }
        return rank;
    }
}