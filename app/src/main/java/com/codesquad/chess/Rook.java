package com.codesquad.chess;

import com.codesquad.chess.pieces.Piece;

public class Rook extends  Piece {

    public Rook(Color color) {
        super(color, Type.ROOK);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        return false;
    }
}
