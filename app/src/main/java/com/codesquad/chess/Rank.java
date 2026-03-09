package com.codesquad.chess;

import com.codesquad.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private List<Piece> pieces = new ArrayList<>();

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    public String getRankRepresentation() {
        StringBuilder sb = new StringBuilder();
        for(Piece piece : pieces) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

    public int getPieceCount(Piece.Color color, Piece.Type type) {
        int count = 0;
        for (Piece piece : pieces) {
            if(piece.getColor() == color && piece.getType() == type)
                count++;
            }
        return count;
    }

    public Piece getPiece(int xPos) {
        return pieces.get(xPos);
    }
}
