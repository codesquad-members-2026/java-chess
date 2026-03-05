package com.codesquad.chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Piece> whitePieces = new ArrayList<>();
    private List<Piece> blackPieces = new ArrayList<>();

    public void add(Piece piece) {
        if (piece.isWhite()) {
            whitePieces.add(piece);
            return;
        }

        if (piece.isBlack()) {
            blackPieces.add(piece);
        }
    }

    public int size() {
        return whitePieces.size() + blackPieces.size();
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            add(Piece.createWhitePawn());
            add(Piece.createBlackPawn());
        }
    }

    public String getWhitePiecesResult() {
        return getPiecesResult(whitePieces);
    }

    public String getBlackPiecesResult() {
        return getPiecesResult(blackPieces);
    }

    private String getPiecesResult(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pieces) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

}
