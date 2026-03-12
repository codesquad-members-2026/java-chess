package com.codesquad.chess.pieces;

import com.codesquad.chess.Board;
import com.codesquad.chess.Direction;
import com.codesquad.chess.Position;

import java.util.List;

public class Queen extends Piece {

    public Queen(Color color) {
        super(color, Type.QUEEN);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        List<Direction> Directions = Direction.everyDirection();

        for (Direction dir : Directions) {
            if (checkPath(source, target, board, dir)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkPath(Position current, Position target, Board board, Direction dir) {
        Position next = new Position(current.getX() + dir.getXDegree(), current.getY() + dir.getYDegree());

        if (!next.isVaild()) return false;
        if (next.equals(target)) return true;
        if (board.findPiece(next).getType() != Type.NO_PIECE) return false;

        return checkPath(next, target, board, dir);
    }
}