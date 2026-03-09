package com.codesquad.chess;

import com.codesquad.chess.pieces.Piece;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BoardTest {
    private Board board;

    @Before
    public void setup() {
        board = new Board();
    }

    @Test
    public void move() throws Exception {
        board.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        board.move(sourcePosition, targetPosition);

        assertEquals(Piece.createWhitePawn(), board.findPiece("b3"));

        assertEquals(Piece.createWhitePawn(), board.findPiece(targetPosition));
    }
}