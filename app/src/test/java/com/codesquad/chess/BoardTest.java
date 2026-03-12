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
    public void moveKing() {
        game.move("e2", "e4"); // 길 터주기
        game.move("e1", "e2"); // 전진
        assertEquals(Piece.createWhiteKing(), board.findPiece("e2"));

        game.move("e2", "f3"); // 대각선 한 칸
        assertEquals(Piece.createWhiteKing(), board.findPiece("f3"));
    }

    @Test
    public void moveKnight() {
        // 나이트는 앞의 폰을 뛰어넘을 수 있음!
        game.move("b1", "c3");
        assertEquals(Piece.createWhiteKnight(), board.findPiece("c3"));

        game.move("c3", "a4"); // L자 이동
        assertEquals(Piece.createWhiteKnight(), board.findPiece("a4"));
    }

    @Test
    public void moveRookAndBishop() {
        // 룩 테스트: 앞의 폰을 치우고 직선 이동
        game.move("h2", "h4");
        game.move("h1", "h3");
        assertEquals(Piece.createWhiteRook(), board.findPiece("h3"));

        // 비숍 테스트: 대각선 길 터주고 이동
        game.move("b2", "b3");
        game.move("c1", "a3");
        assertEquals(Piece.createWhiteBishop(), board.findPiece("a3"));
    }
    @Test
    public void moveQueenObstacle() {
        // 퀸은 폰을 뛰어넘을 수 없음
        game.move("d1", "d3"); // 폰이 막고 있는 상태
        // 이동 실패 시 d1에 그대로 있어야 함
        assertEquals(Piece.createWhiteQueen(), board.findPiece("d1"));
    }

    @Test
    public void movePawn() {
        // 1. 처음 위치에서 2칸 전진
        game.move("a2", "a4");
        assertEquals(Piece.createWhitePawn(), board.findPiece("a4"));

        // 2. 이미 한 번 움직인 폰은 2칸 전진 불가
        game.move("a4", "a6"); // 실패해야 함
        assertEquals(Piece.createWhitePawn(), board.findPiece("a4"));

        // 3. 대각선 공격
        game.move("b7", "b5"); // 블랙 폰 전진 (a4와 b5는 대각선)
        game.move("a4", "b5"); // 화이트가 블랙을 잡음
        assertEquals(Piece.createWhitePawn(), board.findPiece("b5"));
    }



}
