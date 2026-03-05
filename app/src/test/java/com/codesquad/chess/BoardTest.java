package com.codesquad.chess;

import com.codesquad.chess.piece.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codesquad.chess.Board.BOARD_LENGTH;
import static com.codesquad.chess.ChessConstant.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    private Board board;

    // @Test 어노테이션이 붙은 메서드들 실행 전 실행
    @BeforeEach
    public void setUp(){
        board = new Board();
    }

//    @Test
//    @DisplayName("말이 올라올 수 있는 보드판")
//    public void testPawnsOnTheBoard(){
//        toBoardAddSizeFind(new Piece(PAWN, WHITE_COLOR), 1, 0);
//        toBoardAddSizeFind(new Piece(PAWN, BLACK_COLOR), 2, 1);
//    }

    private void toBoardAddSizeFind(Piece piece, int expectedSize, int expectedIndex){
        board.add(piece);
        assertEquals(expectedSize, board.size());
        assertEquals(piece, board.findPawn(expectedIndex));
    }

    @Test
    @DisplayName("보드판에 흰/검정색 Pawn 각 8개씩 추가")
    public void initialize() {
        board.initialize();

        StringBuilder whiteReps = new StringBuilder();
        StringBuilder blackReps = new StringBuilder();
        whiteReps.append(WHITE_CHESS_PAWN.repeat(BOARD_LENGTH));
        blackReps.append(BLACK_CHESS_PAWN.repeat(BOARD_LENGTH));

        assertEquals(whiteReps.toString(), board.getWhitePawnsResult());
        assertEquals(blackReps.toString(), board.getBlackPawnsResult());
    }

    @Test
    @DisplayName("추가된 각 색의 폰들을 콘솔에 출력")
    public void print() {
        board.initialize();

        String expected =
                "·  ·  ·  ·  ·  ·  ·  ·  \n" +
                "♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟ \n" +
                "·  ·  ·  ·  ·  ·  ·  ·  \n" +
                "·  ·  ·  ·  ·  ·  ·  ·  \n" +
                "·  ·  ·  ·  ·  ·  ·  ·  \n" +
                "·  ·  ·  ·  ·  ·  ·  ·  \n" +
                "♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙ \n" +
                "·  ·  ·  ·  ·  ·  ·  ·  \n";

        assertEquals(expected, board.print());
    }
}
