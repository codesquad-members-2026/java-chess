package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.Position;

public class Queen extends Piece {

    public Queen(Piece.Color color, char representation, double point, Position position){
        super(color, representation, point, position);
    }

    @Override
    public boolean verifyMovePosition(Position target, Board board){

        return true;
    }
}
