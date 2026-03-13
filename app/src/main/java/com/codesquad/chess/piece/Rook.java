package com.codesquad.chess.piece;
import com.codesquad.chess.Position;

public class Rook extends DiagonalStraightPiece {

    public Rook(Color color, char representation, double point, com.codesquad.chess.Position position){
        super(color, representation, point, position);
    }

    boolean isValidPath(Position source, Position target){
        return source.getX() == target.getX() || source.getY() == target.getY();
    }
}
