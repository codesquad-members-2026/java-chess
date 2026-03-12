package com.codesquad.chess;

import com.codesquad.chess.pieces.Piece;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color, Type.PAWN);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        int diffX = target.getX() - source.getX();
        int diffY = target.getY() - source.getY();

        int direction = (getColor() == Color.WHITE) ? -1 : 1;

        if (diffX != 0) return false;

        if(diffY == direction) {
            return board.findPiece(target).getType() == Type.NO_PIECE;
        }
        return false;
    }
}
