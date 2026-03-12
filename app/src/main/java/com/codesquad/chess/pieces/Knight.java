package com.codesquad.chess.pieces;

import com.codesquad.chess.Board;
import com.codesquad.chess.Direction;
import com.codesquad.chess.Position;

import java.util.List;

public class Knight extends  Piece {

    public Knight(Color color) {
        super(color, Type.KNIGHT);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        List<Direction> Directions = Direction.knightDirection();

        for (Direction dir : Directions) {
            int nextX = source.getX() + dir.getXDegree();
            int nextY = source.getY() + dir.getYDegree();

            if (target.getX() == nextX && target.getY() == nextY) return true;
        }

        return false;
    }
}
