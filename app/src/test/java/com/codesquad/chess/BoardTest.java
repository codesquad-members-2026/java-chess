package com.codesquad.chess;
<<<<<<< HEAD
import static com.codesquad.chess.utils.StringUtils.appendNewLine;
import static org.junit.Assert.*;


import com.codesquad.chess.pieces.Piece;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
=======
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import pieces.Pawn;


public class BoardTest {

>>>>>>> upstream/Hana
    private Board board;

    @Before
    public void setup() {
        board = new Board();
    }

    @Test
<<<<<<< HEAD
    public void calculatePoint() throws Exception {

        board.initializeEmpty();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());


        assertEquals(15.0, board.calculatePoint(Piece.Color.BLACK), 0.01);
        assertEquals(7.0, board.calculatePoint(Piece.Color.WHITE), 0.01);


        System.out.println(board.showBoard());
        System.out.println("Black Score: " + board.calculatePoint(Piece.Color.BLACK));
        System.out.println("White Score: " + board.calculatePoint(Piece.Color.WHITE));
    }


    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }



=======
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
>>>>>>> upstream/Hana
}