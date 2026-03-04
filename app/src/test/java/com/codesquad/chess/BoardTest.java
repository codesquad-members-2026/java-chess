package com.codesquad.chess;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import pieces.Pawn;


public class BoardTest {

    private Board board;

    @Before
    public void setsup() {
        board = new Board();
    }
   /* @Test
    public void create() throws Exception {

        Pawn white = new Pawn(Pawn.WHITE_COLOR,Pawn.WHITE_REPRESENTATION);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn(Pawn.BLACK_COLOR,Pawn.BLACK_REPRESENTATION);
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
    }*/

    @Test
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();

        assertEquals(16, board.size());
    }
}
