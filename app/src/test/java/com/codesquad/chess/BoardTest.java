package com.codesquad.chess;

import com.codesquad.chess.piece.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codesquad.chess.piece.Piece.*;
import static com.codesquad.chess.utils.StringUtils.appendNewLine;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp(){
        board = new Board();
    }

    @Test
    @DisplayName("체스판 초기화 구현")
    public void create_초기체스판(){
        board.initialize();
        assertEquals(64, board.pieceCount());

        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr"),
                board.showBoard());
    }

    @Test
    public void check_기물의_종류와_색에_따른_기물의_개수반환(){
        String testStr = ".KR.....\n" +
                "P.PB....\n" +
                ".P..Q...\n" +
                "........\n" +
                ".....nq.\n" +
                ".....p..\n" +
                "......p.\n" +
                "....rk..";
        Piece piece = createBlackPawn();

        // Black Pawn의 개수는?
        int result = board.checkPieceNum(piece, testStr);

        assertEquals(3, result);
    }
}
