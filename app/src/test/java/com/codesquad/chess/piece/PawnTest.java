package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.ChessView;
import com.codesquad.chess.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PawnTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("폰은 처음 한 칸 혹은 두 칸 북쪽으로 전진할 수 있다.")
    public void verifyMovePosition_InitialPosition_CanMoveOneOrTwoSquares(){
        board.initialize();

        // 초기 설정
        Piece whitePawn = Piece.createWhitePawn(Position.of("d2"));
        Piece blackPawn = Piece.createBlackPawn(Position.of("e2"));

        // 첫 이동 시 한칸 혹은 두 칸 이동할 수 있음
        // 흰색 폰 테스트
        board.move("d2", "d3"); // 한 칸 이동
        board.move("e2", "e4"); // 두 칸 이동
        assertEquals(whitePawn, board.findPiece(Position.of("d3")));
        assertEquals(whitePawn, board.findPiece(Position.of("e4")));
        // 검정 폰 테스트
        board.move("f7", "f6"); // 한 칸 이동
        board.move("g7", "g5"); // 두 칸 이동
        assertEquals(blackPawn, board.findPiece(Position.of("f6")));
        assertEquals(blackPawn, board.findPiece(Position.of("g5")));
        System.out.println(ChessView.showBoard(board.getRanks()));

        // 첫 이동 후 한 칸만 전진할 수 있다.
        // 흰색 폰 테스트
        board.move("d3", "d4"); // 한 칸 이동은 가능
        board.move("e4", "e6"); // 두 칸 이동은 불가
        assertEquals(whitePawn, board.findPiece(Position.of("d4")));
        assertEquals(whitePawn, board.findPiece(Position.of("e4"))); // 이동이 거부된 상태
        System.out.println(ChessView.showBoard(board.getRanks()));
        // 검정 폰 테스트
        board.move("f6", "f5"); // 한 칸 이동은 가능
        board.move("g5", "g3"); // 두 칸 이동은 불가
        assertEquals(blackPawn, board.findPiece(Position.of("f5")));
        assertEquals(blackPawn, board.findPiece(Position.of("g5"))); // 이동이 거부된 상태
        System.out.println(ChessView.showBoard(board.getRanks()));
    }

    @Test
    @DisplayName("폰은 적 기물이 대각선 방향에 있어야만 대각 이동이 가능하다.")
    public void verifyMovePosition_DiagonalCapture_ReturnsTrue(){
        board.initialize();

        Piece whitePawn = Piece.createWhitePawn(Position.of("d6"));
        Piece blackPawn = Piece.createBlackPawn(Position.of("e3"));
        board.move("d2", "d4"); // 한칸 전진하고 실패한 뒤 잡는 역할
        board.move("e2", "e4");
        board.move("d7", "d5"); // 한칸 전진하고 실패한 뒤 잡는 역할
        board.move("e7", "e5");

        // d4의 whitePawn 한 칸 전진 후 실패, 이후 대각으로 전진하여 적 기물을 잡는다.
        board.move("d4", "d5");
        assertEquals(whitePawn, board.findPiece(Position.of("d4"))); // 실패
        board.move("d4", "e5");
        assertEquals(whitePawn, board.findPiece(Position.of("e5"))); // 성공

        // d7의 blackPawn 한 칸 전진 후 실패, 이후 대각으로 전진하여 적 기물을 잡는다.
        board.setPiece(Position.of("d4"), whitePawn);
        board.move("d5", "d4");
        assertEquals(blackPawn, board.findPiece(Position.of("d5"))); // 실패
        board.move("d5", "e4");
        assertEquals(blackPawn, board.findPiece(Position.of("e4"))); // 성공
    }

    @Test
    @DisplayName("폰이 두 칸 이동 시 적을 뛰어넘어서는 안 된다")
    public void verifyMovePosition_InFrontOfPiece_ReturnsFalse(){
        board.initialize();

        Position pos = Position.of("e3");
        Piece whitePawn = Piece.createWhitePawn(pos);
        board.setPiece(pos, whitePawn);
        System.out.println(ChessView.showBoard(board.getRanks()));

        board.move("e2", "e4");
        assertEquals(whitePawn, board.findPiece(Position.of("e2")));
        assertFalse(board.findPiece(Position.of("e4")).equals(whitePawn));
    }
}
