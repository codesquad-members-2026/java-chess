package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.Position;

public class Rook extends Piece {

    public Rook(Color color, char representation, double point, com.codesquad.chess.Position position){
        super(color, representation, point, position);
    }

    @Override
    public boolean verifyMovePosition(Position target, Board board){

        return true;
    }
}
