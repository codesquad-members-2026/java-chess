package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.Direction;
import com.codesquad.chess.Position;

public class Knight extends Piece {

    public Knight(Color color, char representation, double point, Position position){
        super(color, representation, point, position);
    }

    @Override
    public boolean verifyMovePosition(Position target, Board board){
        Position source = this.getPosition();

        int directionX = target.getX() - source.getX();
        int directionY = source.getY() - target.getY();

        for(Direction d : Direction.knightDirection()){
            if(directionX == d.getXDegree() && directionY == d.getYDegree())
                return !isTeam(target, board);
        }

        return false;
    }

    private boolean isTeam(Position target, Board board){
        Color targetColor = board.findPiece(target).getColor();
        Color myColor = this.getColor();

        return targetColor.equals(myColor);
    }
}
