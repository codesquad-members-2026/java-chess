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
    public void move_실패_선택한_위치에_기물없음() {
        // 1. 빈 공간(e3)을 선택해서 d4로 옮기려고 시도
        game.move("e3", "d4");

        // 결과: e3는 여전히 Blank여야 하고, d4도 Blank여야 함
        assertEquals(Piece.createBlank(), board.findPiece("e3"));
        assertEquals(Piece.createBlank(), board.findPiece("d4"));
    }

    @Test
    public void move_실패_움직임_규칙_위반() {
        // 2. 룩(a1)을 대각선(b2)으로 옮기려고 시도 (룩은 직선만 가능)
        game.move("a1", "b2");

        // 결과: a1에 여전히 화이트 룩이 있어야 함 (이동하지 않음)
        assertEquals(Piece.createWhiteRook(), board.findPiece("a1"));
    }

    @Test
    public void move_실패_아군_공격_불가() {
        // 3. 킹(e1)을 아군 폰이 있는 e2로 옮기려고 시도 (폰을 치우지 않고)
        game.move("e1", "e2");

        // 결과: e1에는 킹, e2에는 여전히 폰이 있어야 함
        assertEquals(Piece.createWhiteKing(), board.findPiece("e1"));
        assertEquals(Piece.createWhitePawn(), board.findPiece("e2"));
    }
}
