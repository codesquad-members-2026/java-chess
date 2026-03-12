package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.Direction;
import com.codesquad.chess.Position;

public class Pawn extends Piece {

    private boolean wasMoved;
    public static int ONE_STEP_X_VAL = 0;
    public static int TWO_STEP_Y_VAL = 2;
    public static int WHITE_PAWN_START_Y_IDX = 6;

    public Pawn(Piece.Color color, char representation, double point, Position position){
        super(color, representation, point, position);
        wasMoved = false;
    }

    @Override
    public boolean verifyMovePosition(Position target, Board board){
        int xMinus = this.getPosition().getX() - target.getX();
        int yMinus = this.getPosition().getY() - target.getY();

        // 한 칸 전진 혹은 대각 전진 확인 --> 더 세분화 필요
        for(Direction d : Direction.whitePawnDirection()){
            if(d.getXDegree() == xMinus && d.getYDegree() == yMinus){
                return true;
            }
        }
        
        // 두 칸 전진 로직 확인
        if(xMinus == ONE_STEP_X_VAL && yMinus == TWO_STEP_Y_VAL
                && !wasMoved && this.getPosition().getY() == WHITE_PAWN_START_Y_IDX){
            wasMoved = true;
            return true;
        }

        return false;
    }
}
