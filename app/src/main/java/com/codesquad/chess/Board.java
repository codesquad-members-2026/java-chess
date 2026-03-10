package com.codesquad.chess;

import com.codesquad.chess.pieces.Piece;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Rank> ranks = new ArrayList<>();
    public static final int SIZE = 8;

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

    public void setPiece(Position pos, Piece piece) {
        ranks.get(pos.getY()).setPiece(pos.getX(), piece);
    }
    
    public Piece findPiece(Position pos) {
        return ranks.get(pos.getY()).getPiece(pos.getX());
    }

    public Piece findPiece(String positionStr) {
        return findPiece(new Position(positionStr));
    }
    
    public List<Rank> getRanks() {
        return ranks;
    }
}