package com.codesquad.chess;

import com.codesquad.chess.pieces.Piece;
import java.util.ArrayList;
import java.util.List;

public class Rank {
    private final List<Piece> pieces = new ArrayList<>();

    public void addPiece(Piece piece) { pieces.add(piece); }
    public void setPiece(int xPos, Piece piece) { pieces.set(xPos, piece); }
    public Piece getPiece(int xPos) { return pieces.get(xPos); }

    public String getRankRepresentation() {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pieces) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }
}