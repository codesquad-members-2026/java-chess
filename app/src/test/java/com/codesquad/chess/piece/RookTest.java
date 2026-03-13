package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RookTest {

    private Board board;

    @BeforeEach
    public void setUp(){
        board = new Board();
    }

    @Test
    @DisplayName("비숍 기물의 이동 테스트")
    public void verifyMovePosition_Move_StraightLine(){
        board.initializeEmptyBoard();

        // 초기 설정
        Piece rook = Piece.createWhiteRook(Position.of("d4"));
        board.setPiece(Position.of("d4"), rook);
        assertEquals(rook, board.findPiece(Position.of("d4")));

        // 왼쪽 이동
        board.move("d4", "a4");
        assertEquals(rook, board.findPiece(Position.of("a4")));

        // 오른쪽 이동
        board.move("a4", "d4");
        assertEquals(rook, board.findPiece(Position.of("d4")));

        // 오른쪽 아래 이동
        board.move("d4", "d1");
        assertEquals(rook, board.findPiece(Position.of("d1")));

        // 왼쪽 위 이동
        board.move("d1", "d4");
        assertEquals(rook, board.findPiece(Position.of("d4")));

        // 장애물이 존재한다면?
        Piece whitePawn1 = Piece.createWhitePawn(Position.of("c4"));
        Piece whitePawn2 = Piece.createWhitePawn(Position.of("d7"));
        Piece blackPawn1 = Piece.createBlackPawn(Position.of("f4"));
        Piece blackPawn2 = Piece.createBlackPawn(Position.of("d2"));
        board.setPiece(Position.of("c4"), whitePawn1);
        board.setPiece(Position.of("d7"), whitePawn2);
        board.setPiece(Position.of("f4"), blackPawn1);
        board.setPiece(Position.of("d2"), blackPawn2);

        board.move("d4", "b4"); // 왼
        board.move("d4", "d8"); // 위
        board.move("d4", "g4"); // 오
        board.move("d4", "g1"); // 아

        // 4번에 움직임에도 rook은 d4에 존재해야 한다.
        assertEquals(rook, board.findPiece(Position.of("d4")));
    }
}
