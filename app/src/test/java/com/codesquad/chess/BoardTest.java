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
        board = new Board();
    }

    @Test
    public void move() throws Exception {

        game.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";

        game.move(sourcePosition, targetPosition);
        assertEquals(Piece.createBlank(), board.findPiece(sourcePosition));
        assertEquals(Piece.createWhitePawn(), board.findPiece(targetPosition));
    }

    @Test
    public void calculatePoint() throws Exception {
        game.initialize();

        assertEquals(38.0, game.calculatePoint(Piece.Color.BLACK), 0.01);
        assertEquals(38.0, game.calculatePoint(Piece.Color.WHITE), 0.01);
    }
}
