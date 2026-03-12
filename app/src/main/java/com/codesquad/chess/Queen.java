package com.codesquad.chess;

import com.codesquad.chess.pieces.Piece;

public class Queen extends Piece {

    public Queen(Color color) {
        super(color, Type.QUEEN);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        int diffX = target.getX() - source.getX();
        int diffY = target.getY() - source.getY();

        boolean isStraight = (diffX == 0 || diffY == 0);
        boolean isDiagonal = Math.abs(diffX) == Math.abs(diffY);

        if (!(isStraight || isDiagonal)) return false;

        int dirX = Integer.compare(target.getX(), source.getX());
        int dirY = Integer.compare(target.getY(), source.getY());

        return queenCanGo(source, target, dirX, dirY, board);
    }

    private boolean queenCanGo(Position current, Position target, int dirX, int dirY, Board board) {
        Position next = new Position(current.getX() + dirX, current.getY() + dirY);

        if (next.equals(target)) return true;

        if (board.findPiece(next).getType() != Type.NO_PIECE) return false;

        return queenCanGo(next, target, dirX, dirY, board);
    }
}