package com.codesquad.chess;

import com.codesquad.chess.piece.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    private Board board;

    // @Test 어노테이션이 붙은 메서드들 실행 전 실행
    @BeforeEach
    public void setUp(){
        board = new Board();
        System.out.println("보드 초기화 완료");
    }

    @Test
    @DisplayName("말이 올라올 수 있는 보드판")
    public void testPawnsOnTheBoard(){
        toBoardAddSizeFind(new Pawn(Pawn.WHITE_COLOR), 1, 0);
        toBoardAddSizeFind(new Pawn(Pawn.BLACK_COLOR), 2, 1);

        // Pawn 이외의 다른 객체 추가시 오류 발생
        // board.add(new Integer(7));
    }

    private void toBoardAddSizeFind(Pawn pawn, int expectedSize, int expectedIndex){
        board.add(pawn);
        assertEquals(expectedSize, board.size());
        assertEquals(pawn, board.findPawn(expectedIndex));
    }
}
