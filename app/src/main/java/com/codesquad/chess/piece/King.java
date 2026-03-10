package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.Position;

public class King extends Piece {

    public King(Color color, char representation, double point, Position position){
         super(color, representation, point, position);
    }

    @Override
    public boolean canMoveTo(Position target, Board board){

        return true;
    }
}
