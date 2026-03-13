package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.Direction;
import com.codesquad.chess.Position;
import com.codesquad.chess.exception.UnreachableDirectionException;

import static com.codesquad.chess.utils.StringUtils.appendNewLine;

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

        // 어느 방향으로 갈 것인가?
        Direction direction = findDirection(source, target);

        return recurTarget(source, target, direction, board);
    }

    private boolean recurTarget(Position source, Position target, Direction direction, Board board){
        // 종료 조건
        if(isEqual(source, target)){
            return true;
        }

        int nextX = source.getX() + direction.getXDegree();
        int nextY = source.getY() - direction.getYDegree();
        Position nextPosition = Position.of(nextX, nextY);

        // 다음 이동 경로에 BLANK 기물이 아닌 기물이 존재한다면
        if(!board.findPiece(nextPosition).getType().equals(Type.NO_PIECE))
            return false;

        return recurTarget(nextPosition, target, direction, board);
    }

    private Direction findDirection(Position source, Position target){
        int xSignum = Integer.signum(target.getX() - source.getX());
        // y 좌표는 도메인적으로 [0]을 8번째 Rank, [7]을 첫 번째 Rank로 인지한다.
        int ySignum = Integer.signum(source.getY() - target.getY());

        for(Direction direction : Direction.everyDirection()){
            if(direction.getXDegree() == xSignum && direction.getYDegree() == ySignum){
                return direction;
            }
        }

        throw new UnreachableDirectionException(
                appendNewLine("출발지와 도착지로 방향을 계산할 수 없습니다.") +
                appendNewLine("source: [" + source.getX() + ", " + source.getY() + "]") +
                appendNewLine("target: [" + target.getX() + ", " + target.getY() + "]"));
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
