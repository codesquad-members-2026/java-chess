package com.codesquad.chess;

import com.codesquad.chess.pieces.Piece;

public class Knight extends  Piece {

    public Knight(Color color) {
        super(color, Type.KNIGHT);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        return false;
    }
}
