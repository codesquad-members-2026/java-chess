package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueenTest {

    private Board board;

    @BeforeEach
    public void setUp(){
        board = new Board();
    }

    @Test
    @DisplayName("퀸 기물의 이동 테스트")
    public void verifyMovePosition_Move_StraightLine_And_DiagonalLine(){
        board.initializeEmptyBoard();

        Piece queen = Piece.createWhiteQueen(Position.of("e5"));
        board.setPiece(Position.of("e5"), queen);

        assertEquals(queen, board.findPiece(Position.of("e5")));
        // 왼쪽 아래 대각 이동
        board.move("e5", "a1");
        assertEquals(queen, board.findPiece(Position.of("a1")));

        // 오른쪽 위 대각 이동
        board.move("a1", "h8");
        assertEquals(queen, board.findPiece(Position.of("h8")));

        // 왼쪽 이동
        board.move("h8", "a8");
        assertEquals(queen, board.findPiece(Position.of("a8")));

        // 오른쪽 아래 대각 이동
        board.move("a8", "h1");
        assertEquals(queen, board.findPiece(Position.of("h1")));

        // 왼쪽 위 대각 이동
        board.move("h1", "a8");
        assertEquals(queen, board.findPiece(Position.of("a8")));

        // 오른쪽 이동
        board.move("a8", "h8");
        assertEquals(queen, board.findPiece(Position.of("h8")));

        // 아래 이동
        board.move("h8", "h1");
        assertEquals(queen, board.findPiece(Position.of("h1")));

        // 위 이동
        board.move("h1", "h8");
        assertEquals(queen, board.findPiece(Position.of("h8")));

        // 장애물이 존재한다면?
        Piece whitePawn = Piece.createWhitePawn(Position.of("f6"));
        Piece blackPawn = Piece.createBlackPawn(Position.of("h4"));
        board.setPiece(Position.of("f6"), whitePawn);
        board.setPiece(Position.of("h4"), blackPawn);

        // whitePawn에 의해 움직임 취소
        board.move("h8", "e5");
        assertEquals(queen, board.findPiece(Position.of("h8")));

        // blackPawn에 의해 움직임 취소
        board.move("h8", "h1");
        assertEquals(queen, board.findPiece(Position.of("h8")));
    }

    @Test
    @DisplayName("퀸은 목표 지점에 팀 기물이 있으면 이동하지 않고, 적이나 빈칸이 있으면 이동한다.")
    public void verifyMovePosition_WhenTargetIsTeam_ReturnFalse(){
        board.initializeEmptyBoard();

        Piece queen = Piece.createWhiteQueen(Position.of("e5"));
        board.setPiece(Position.of("e5"), queen);
        Piece whitePawn = Piece.createWhitePawn(Position.of("c3"));
        board.setPiece(Position.of("c3"), whitePawn);
        Piece blackPawn = Piece.createBlackPawn(Position.of("e8"));
        board.setPiece(Position.of("e8"), blackPawn);

        // 같은 팀에게 move
        board.move("e5", "c3");
        assertEquals(queen, board.findPiece(Position.of("e5")));
        // 다른 팀에게 move
        board.move("e5", "e8");
        assertEquals(queen, board.findPiece(Position.of("e8")));
    }
}
