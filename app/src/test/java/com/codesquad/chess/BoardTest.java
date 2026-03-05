package com.codesquad.chess;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import pieces.Pawn;


public class BoardTest {

    private Board board;

    @Before
    public void setup() {
        board = new Board();
    }

    @Test
    public void initialize() throws Exception {

        board.initialize();
        assertEquals(16, board.size());
    }

    @Test
    public void initialize_result() {
        board.initialize();

        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }

    @Test
    public void print() {
        board.initialize();
        System.out.println(board.showBoard());
    }
}