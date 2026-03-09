package com.codesquad.chess;
import static com.codesquad.chess.utils.StringUtils.appendNewLine;
import static org.junit.Assert.*;


import com.codesquad.chess.pieces.Piece;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    private Board board;

    @Before
    public void setup() {
        board = new Board();
    }

    @Test
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



}