package com.codesquad.chess;

import com.codesquad.chess.pieces.Piece;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BoardTest {
    private ChessGame game;
    private Board board;

    @Before
    public void setup() {
        game = new ChessGame();
        game.initialize();

        this.board =  game.getBoard();

    }

    @Test
    public void moveKingSuccess() throws Exception {
        // 1. 킹 앞에 있는 폰을 먼저 치워줍니다 (이동 경로 확보)
        game.move("e2", "e3");

        // 2. 킹을 한 칸 위로 이동 (e1 -> e2)
        game.move("e1", "e2");

        assertEquals(Piece.createWhiteKing(), board.findPiece("e2"));
        assertEquals(Piece.createBlank(), board.findPiece("e1"));
    }

    @Test
    public void moveQueenSuccess() throws Exception {
        // d2 폰을 치워서 길을 엽니다.
        game.move("d2", "d3");
        // d1 퀸을 d2로 이동 (한 칸)
        game.move("d1", "d2");
        assertEquals(Piece.createWhiteQueen(), board.findPiece("d2"));

        // d2 퀸을 h6로 이동 (대각선 멀리 이동)
        game.move("d2", "h6");
        assertEquals(Piece.createWhiteQueen(), board.findPiece("h6"));
        assertEquals(Piece.createBlank(), board.findPiece("d2"));


    }


}
