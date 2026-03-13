package com.codesquad.chess.piece;

import com.codesquad.chess.Position;

public class Queen extends DiagonalStraightPiece {

    public Queen(Piece.Color color, char representation, double point, Position position){
        super(color, representation, point, position);
    }

    private boolean isDiagonal(Position source, Position target){
        return Math.abs(source.getX() - target.getX()) == Math.abs(source.getY() - target.getY());
    }
    private boolean isStraight(Position source, Position target){
        return source.getX() == target.getX() || source.getY() == target.getY();
    }
    boolean isValidPath(Position source, Position target){
        return isDiagonal(source, target) || isStraight(source, target);
    }
}
