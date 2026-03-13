package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BishopTest {

    private Board board;

    @BeforeEach
    public void setUp(){
        board = new Board();
    }

    @Test
    @DisplayName("비숍 기물의 이동 테스트")
    public void verifyMovePosition_Move_DiagonalLine(){
        board.initializeEmptyBoard();

        // 초기 설정
        Piece bishop = Piece.createWhiteBishop(Position.of("h8"));
        board.setPiece(Position.of("h8"), bishop);
        assertEquals(bishop, board.findPiece(Position.of("h8")));

        // 왼쪽 아래 대각 이동
        board.move("h8", "a1");
        assertEquals(bishop, board.findPiece(Position.of("a1")));

        // 오른쪽 위 대각 이동
        board.move("a1", "d4");
        assertEquals(bishop, board.findPiece(Position.of("d4")));

        // 오른쪽 아래 대각 이동
        board.move("d4", "g1");
        assertEquals(bishop, board.findPiece(Position.of("g1")));

        // 왼쪽 위 대각 이동
        board.move("g1", "c5");
        assertEquals(bishop, board.findPiece(Position.of("c5")));


        // 장애물이 존재한다면?
        Piece whitePawn = Piece.createWhitePawn(Position.of("d4"));
        Piece blackPawn = Piece.createBlackPawn(Position.of("b6"));
        board.setPiece(Position.of("d4"), whitePawn);
        board.setPiece(Position.of("b6"), blackPawn);

        // whitePawn에 의해 움직임 취소
        board.move("c5", "e3");
        assertEquals(bishop, board.findPiece(Position.of("c5")));

        // blackPawn에 의해 움직임 취소
        board.move("c5", "a7");
        assertEquals(bishop, board.findPiece(Position.of("c5")));
    }
}
