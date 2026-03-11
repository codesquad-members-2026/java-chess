package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KingTest {

    private Board board;

    @BeforeEach
    void setUp(){
        board = new Board();
    }

    @Test
    @DisplayName("King은 모든 방향으로 한 칸씩 이동할 수 있어야 한다.")
    public void kingMovesOneSquareInAllDirections(){
        board.initialize();

        // 킹 주변의 기물들 치우기
        board.move("d2", "d5");
        board.move("e2", "e5");
        board.move("f2", "f5");
        board.move("d1", "d6");
        board.move("f1", "f6");
        Piece king = Piece.createWhiteKing(Position.of("a3"));

        // 전진
        board.move("e1", "e2");
        assertEquals(king, board.findPiece(Position.of("e2")));

        // 왼쪽 대각선 전진이동
        board.move("e2", "d3");
        assertEquals(king, board.findPiece(Position.of("d3")));

        // 오른쪽 대각선 전진이동
        board.move("d3", "e4");
        assertEquals(king, board.findPiece(Position.of("e4")));

        // 오른쪽 대각선 후진이동
        board.move("e4", "f3");
        assertEquals(king, board.findPiece(Position.of("f3")));

        // 왼쪽 대각선 후진이동
        board.move("f3", "e2");
        assertEquals(king, board.findPiece(Position.of("e2")));

        // 왼쪽 이동
        board.move("e2", "d2");
        assertEquals(king, board.findPiece(Position.of("d2")));

        // 오른쪽 이동
        board.move("d2", "e2");
        assertEquals(king, board.findPiece(Position.of("e2")));

        // 후진
        board.move("e2", "e1");
        assertEquals(king, board.findPiece(Position.of("e1")));
    }
}
