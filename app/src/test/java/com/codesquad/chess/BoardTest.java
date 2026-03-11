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
    public void moveQueenSuccess() {
        // 1. 퀸 앞의 폰을 치움
        game.move("d2", "d3");
        // 2. 퀸(d1)이 비어있는 d2로 이동
        game.move("d1", "d2");

        assertEquals(Piece.createWhiteQueen(), board.findPiece("d2"));
        assertEquals(Piece.createBlank(), board.findPiece("d1"));
    }

    @Test
    public void moveKingSuccess() {
        // 1. 킹 앞의 폰을 치움
        game.move("e2", "e3");
        // 2. 킹(e1)이 한 칸 앞(e2)으로 이동
        game.move("e1", "e2");

        assertEquals(Piece.createWhiteKing(), board.findPiece("e2"));
    }

    @Test
    public void movePawnSuccess() {
        game.move("e2", "e3");
        assertEquals(Piece.createWhitePawn(), board.findPiece("e3"));
    }


}
