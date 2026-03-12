package com.codesquad.chess.piece;
import com.codesquad.chess.Position;

public class Bishop extends DiagonalStraightPiece {

    public Bishop(Piece.Color color, char representation, double point, Position position){
        super(color, representation, point, position);
    }

    @Override
    boolean isValidPath(Position source, Position target){
        return Math.abs(source.getX() - target.getX()) == Math.abs(source.getY() - target.getY());
    }
}
