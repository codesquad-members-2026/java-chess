package com.codesquad.chess;

import com.codesquad.chess.pieces.Piece;

public class Blank extends Piece {

    public Blank() {
        super(Color.NOCOLOR, Type.NO_PIECE);
    }

    @Override
    public  boolean canMove(Position sourcePos, Position targetPos, Board board) {
        return false;
    }
}
