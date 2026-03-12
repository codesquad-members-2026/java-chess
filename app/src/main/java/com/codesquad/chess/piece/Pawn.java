package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.Direction;
import com.codesquad.chess.Position;

public class Pawn extends Piece {

    public static int SEC_RANK_IDX = 6;
    public static int SEVENTH_RANK_IDX = 1;
    public static int ONE_STEP_FORWARD = 1;
    public static int TWO_STEP_FORWARD = 2;

    public Pawn(Piece.Color color, char representation, double point, Position position){
        super(color, representation, point, position);
    }

    @Override
    public boolean verifyMovePosition(Position target, Board board){
        int xMinus = target.getX() - this.getPosition().getX(); // 이후 값이 -1이면 왼대각 이동, 1이면 오대각 이동
        int yMinus = this.getPosition().getY() - target.getY();

        // 한 칸 전진 혹은 대각 전진 확인
        Direction direction = findDirection(xMinus, yMinus);

        // 두 칸 이동 로직
        if(direction == null){
            if(!isTwoStep(xMinus, yMinus))
                return false;

            return canMoveTwoStep(target, board);
        }

        // 전진 혹은 대각 이동 로직
        return canMoveOneStep(direction, target, board);
    }
    private Direction findDirection(int x, int y){
        if(this.getColor() == Color.WHITE){
            for(Direction direction : Direction.whitePawnDirection()){
                if(direction.getXDegree() == x && direction.getYDegree() == y){
                    return direction;
                }
            }
        } else if(this.getColor() == Color.BLACK){
            for(Direction direction : Direction.blackPawnDirection()){
                if(direction.getXDegree() == x && direction.getYDegree() == y){
                    return direction;
                }
            }
        }

        return null;
    }
    private boolean canMoveTwoStep(Position target, Board board){
        // 현재 위치가 백이면 rank 2 or 흑이면 rank 7 에 위치
        Color srcColor = this.getColor();
        Position srcPos = this.getPosition();

        if(srcColor == Color.WHITE && srcPos.getY() == SEC_RANK_IDX){
            Type oneStepType = board.findPiece(Position.of(srcPos.getX(), srcPos.getY() - ONE_STEP_FORWARD)).getType();
            Type twoStepType = board.findPiece(Position.of(srcPos.getX(), srcPos.getY() - TWO_STEP_FORWARD)).getType();
            return oneStepType == Type.NO_PIECE && twoStepType == Type.NO_PIECE;
        }

        if(srcColor == Color.BLACK && srcPos.getY() == SEVENTH_RANK_IDX){
            Type oneStepType = board.findPiece(Position.of(srcPos.getX(), srcPos.getY() + ONE_STEP_FORWARD)).getType();
            Type twoStepType = board.findPiece(Position.of(srcPos.getX(), srcPos.getY() + TWO_STEP_FORWARD)).getType();
            return oneStepType == Type.NO_PIECE && twoStepType == Type.NO_PIECE;
        }

        return false;
    }
    private boolean isTwoStep(int xMinus, int yMinus){
        // 남 혹은 북으로 두 칸 이동에 속하지 않으면 false
        Position distance = Position.of(xMinus, yMinus);
        Position nn = Position.of(Direction.NN.getXDegree(), Direction.NN.getYDegree());
        Position ss = Position.of(Direction.SS.getXDegree(), Direction.SS.getYDegree());
        return nn.equals(distance) || ss.equals(distance);
    }
    private boolean canMoveOneStep(Direction direction, Position target, Board board){
        Color targetColor = board.findPiece(target).getColor();

        // 한 칸 전진일 경우 -> 목표 지점이 Blank 객체일 때만 이동
        if(direction == Direction.NORTH || direction == Direction.SOUTH){
            return targetColor == Color.NOCOLOR;
        }

        // 대각일 경우 -> 목표 지점이 적군일 때만 이동
        return targetColor != Color.NOCOLOR && targetColor != this.getColor();
    }
}
