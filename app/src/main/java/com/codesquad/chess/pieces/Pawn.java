package com.codesquad.chess.pieces;

import com.codesquad.chess.Board;
import com.codesquad.chess.Position;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color, Type.PAWN);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        int diffX = target.getX() - source.getX();
        int diffY = target.getY() - source.getY();
        int direction = (getColor() == Color.WHITE) ? -1 : 1;

        if (diffX == 0) {
            if (diffY == direction) {
                return board.findPiece(target).getType() == Type.NO_PIECE;
            }
        }

        if (canTwoStep(source) && diffY == direction * 2) {
            Position middle = new Position(source.getX(), source.getY() + direction);
            return board.findPiece(middle).getType() == Type.NO_PIECE
                    && board.findPiece(target).getType() == Type.NO_PIECE;
        }

        if(Math.abs(diffX) == 1 && diffY == direction) {
            Piece targetPiece = board.findPiece(target);
            return targetPiece.getType() != Type.NO_PIECE && targetPiece.getColor()
                    != getColor();
        }
        return false;
    }

    private boolean canTwoStep(Position source) {
        if (getColor() == Color.WHITE) return source.getY() == 6;
        if (getColor() == Color.BLACK) return source.getY() == 1;

        return false;
    }
}
