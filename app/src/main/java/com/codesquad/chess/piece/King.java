package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.Direction;
import com.codesquad.chess.Position;

public class King extends Piece {

    public King(Color color, char representation, double point, Position position){
         super(color, representation, point, position);
    }

    @Override
    public boolean verifyMovePosition(Position source, Position target, Board board){
        int srcX = source.getX();
        int srcY = source.getY();
        int targetX = target.getX();
        int targetY = target.getY();

        for(Direction d : Direction.everyDirection()){
            if((srcX + d.getXDegree() == targetX) && (srcY + d.getYDegree() == targetY)){
                return true;
            }
        }
        return false;
    }
}
