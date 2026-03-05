package com.codesquad.chess;

import com.codesquad.chess.piece.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codesquad.chess.Board.BOARD_LENGTH;
import static com.codesquad.chess.ChessConstant.*;
import static com.codesquad.chess.utils.StringUtils.appendNewLine;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp(){
        board = new Board();
    }

    @Test
    @DisplayName("전체 기물의 상태를 볼 수 있는 체스판 구현 및 테스트")
    public void create_초기체스판구현(){
        board.initialize();
        assertEquals(32, board.pieceCount());

        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("♜♞♝♛♚♝♞♜") +
                appendNewLine("♟♟♟♟♟♟♟♟") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("♙♙♙♙♙♙♙♙") +
                appendNewLine("♖♘♗♕♔♗♘♖"),
                board.showBoard());
    }
}
