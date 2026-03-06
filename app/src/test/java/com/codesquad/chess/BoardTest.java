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
    public void create() throws Exception {
        board.initialize();
        assertEquals(2, board.countPiece(Piece.Color.BLACK, Piece.Type.BISHOP));
        assertEquals(8,board.countPiece(Piece.Color.BLACK, Piece.Type.PAWN));
    }
}