package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.ChessView;
import com.codesquad.chess.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("흰색폰은 처음 한 칸 혹은 두 칸 북쪽으로 전진할 수 있다.")
    public void verifyMovePosition_At_First_WhitePawn_Can_Move_OneOrTwoSpace(){
        board.initializeEmptyBoard();

        Piece whitePawn1 = Piece.createWhitePawn(Position.of("d2"));
        board.setPiece(Position.of("d2"), whitePawn1);
        Piece whitePawn2 = Piece.createWhitePawn(Position.of("e2"));
        board.setPiece(Position.of("e2"), whitePawn2);
        System.out.println(ChessView.showBoard(board.getRanks()));


        // 첫 이동 시 한칸 혹은 두 칸 이동할 수 있음
        board.move("d2", "d3"); // 한 칸 이동
        board.move("e2", "e4"); // 두 칸 이동
        assertEquals(whitePawn1, board.findPiece(Position.of("d3")));
        assertEquals(whitePawn2, board.findPiece(Position.of("e4")));
        System.out.println(ChessView.showBoard(board.getRanks()));

        // 첫 이동 후 한 칸만 전진할 수 있다.
        board.move("d3", "d4"); // 한 칸 이동은 가능
        board.move("e4", "e6"); // 두 칸 이동은 불가
        assertEquals(whitePawn1, board.findPiece(Position.of("d4")));
        assertEquals(whitePawn2, board.findPiece(Position.of("e4"))); // 이동이 거부된 상태
        System.out.println(ChessView.showBoard(board.getRanks()));
    }
}
