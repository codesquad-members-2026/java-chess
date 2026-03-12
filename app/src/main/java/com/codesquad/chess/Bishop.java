package com.codesquad.chess;

import com.codesquad.chess.pieces.Piece;

public class Bishop extends  Piece {

    public Bishop(Color color) {
        super(color, Type.BISHOP);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        return false;
    }
}
