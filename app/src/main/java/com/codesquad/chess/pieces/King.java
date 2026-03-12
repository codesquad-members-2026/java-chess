package com.codesquad.chess.pieces;

import com.codesquad.chess.Board;
import com.codesquad.chess.Position;

public class King extends Piece {

    public King(Color color) {
        super(color, Type.KING);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        int diffX = Math.abs(target.getX() - source.getX());
        int diffY = Math.abs(target.getY() - source.getY());
        return diffX <= 1 && diffY <= 1;
    }
}