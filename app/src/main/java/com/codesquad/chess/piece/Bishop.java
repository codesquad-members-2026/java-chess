package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.Position;

public class Bishop extends Piece {

    public Bishop(Piece.Color color, char representation, double point, Position position){
        super(color, representation, point, position);
    }

    @Override
    public boolean canMoveTo(Position target, Board board){

        return true;
    }
}
