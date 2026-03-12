package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.Direction;
import com.codesquad.chess.Position;
import com.codesquad.chess.exception.UnreachableDirectionException;

import static com.codesquad.chess.utils.StringUtils.appendNewLine;

public abstract class DiagonalStraightPiece extends Piece {

    public DiagonalStraightPiece(Piece.Color color, char representation, double point, Position position){
        super(color, representation, point, position);
    }

    @Override
    public boolean verifyMovePosition(Position target, Board board){
        Position source = this.getPosition();

        if(!isValidPath(source, target)){
            return false;
        }

        Direction direction = findDirection(source, target);

        return recurTarget(source, target, direction, board);
    }

    protected boolean recurTarget(Position source, Position target, Direction direction, Board board){
        // 종료 조건
        if(isEqual(source, target)){
            return true;
        }

        int nextX = source.getX() + direction.getXDegree();
        int nextY = source.getY() - direction.getYDegree();
        Position nextPosition = Position.of(nextX, nextY);

        if(!board.findPiece(nextPosition).getType().equals(Type.NO_PIECE)) // verifySameColor() 사용? 흐음.. 고민
            return false;

        return recurTarget(nextPosition, target, direction, board);
    }
    protected Direction findDirection(Position source, Position target){
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
    protected boolean isEqual(Position source, Position target){
        return source.getX() == target.getX() && source.getY() == target.getY();
    }

    abstract boolean isValidPath(Position source, Position target);
}
