package com.codesquad.chess;

import com.codesquad.chess.piece.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChessGameTest {

    private Board board;
    private ChessGame chessGame;

    @BeforeEach
    public void setUp() {
        board = new Board();
        chessGame = new ChessGame();

        board.initialize();
    }

    @Test
    @DisplayName("인자로 받은 킹 타입의 기물이, 인자로 받은 위치로 움직일 수 있는가?")
    public void passCanKingMoveRuleTest(){
        Piece whiteKing = Piece.createWhiteKing(Position.of("e1"));
        Position target = Position.of("e2");

        assertEquals(false, chessGame.canKingPieceMove(whiteKing, target, board));

    }
}
