package com.codesquad.chess.pieces;

import com.codesquad.chess.Board;
import com.codesquad.chess.Position;

public class Blank extends Piece {

    public Blank() {
        super(Color.NOCOLOR, Type.NO_PIECE);
    }

    @Override
    public  boolean canMove(Position sourcePos, Position targetPos, Board board) {
        return false;
    }
}
