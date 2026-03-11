package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.Direction;
import com.codesquad.chess.Position;

public class Queen extends Piece {

    public Queen(Piece.Color color, char representation, double point, Position position){
        super(color, representation, point, position);
    }

    @Override
    public boolean verifyMovePosition(Position target, Board board){
        Position source = this.getPosition();

        if(!verifyDiagonal(source, target) && !verifyStraight(source, target)){
            return false;
        }

        return recurTarget(this.getPosition(), target, board);
    }

    private boolean recurTarget(Position source, Position target, Board board){
        // 종료 조건
        if(isEqual(source, target)){
            return true;
        }

        // Direction의 everyDirection() 반환 상수들을 돌며 조건에 맞는 가장 가까운 곳으로 이동
        Position origin = source;
        for(Direction d : Direction.everyDirection()){
            Position direction = Position.of(source.getX() + d.getXDegree(), source.getY() - d.getYDegree());

            // 대각선 혹은 직선선상에 있다면 source의 위치와 비교하여 가까울 때 source의 값을 direction으로 변경
            if((verifyDiagonal(direction, target) || verifyStraight(source, target))
                    && compareDistance(source, direction, target)){

                source = direction;
                break;
            }
        }

        // source의 값이 변했어야 하고, source의 실제 위치에 기물이 없어야 다음 재귀로 넘어갈 수 있다.
        return (!origin.equals(source))
                && (board.findPiece(source).getColor() == Color.NOCOLOR)
                && recurTarget(source, target, board);
    }
    private boolean compareDistance(Position source, Position direction, Position target) {
        int desMinusSrc = Math.abs(target.getX() - source.getX())
                + Math.abs(target.getY() - source.getY());
        int desMinusDir = Math.abs(target.getX() - direction.getX()) +
                Math.abs(target.getY() - direction.getY());

        return desMinusSrc > desMinusDir;
    }
    private boolean verifyDiagonal(Position source, Position target){
        return Math.abs(source.getX() - target.getX()) == Math.abs(source.getY() - target.getY());
    }
    private boolean verifyStraight(Position source, Position target){
        return source.getX() == target.getX() || source.getY() == target.getY();
    }
    private boolean isEqual(Position source, Position target){
        return source.getX() == target.getX() && source.getY() == target.getY();
    }
}
