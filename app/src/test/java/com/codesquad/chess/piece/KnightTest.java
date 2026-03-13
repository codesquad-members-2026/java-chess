package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("빈 체스판에서 나이트의 모든 이동을 테스트한다.")
    public void verifyMovePosition_TestEveryMove(){
        board.initializeEmptyBoard();

        Position position = Position.of("e4");
        Piece whiteNight = Piece.createWhiteKnight(position);
        board.setPiece(position, whiteNight);

        // NNW
        board.move("e4", "d6");
        assertEquals(whiteNight, board.findPiece(Position.of("d6")));
        board.move("d6", "e4");

        // NNE
        board.move("e4", "f6");
        assertEquals(whiteNight, board.findPiece(Position.of("f6")));
        board.move("f6", "e4");

        // EEN
        board.move("e4", "g5");
        assertEquals(whiteNight, board.findPiece(Position.of("g5")));
        board.move("g5", "e4");

        // EES
        board.move("e4", "g3");
        assertEquals(whiteNight, board.findPiece(Position.of("g3")));
        board.move("g3", "e4");

        // SSE
        board.move("e4", "f2");
        assertEquals(whiteNight, board.findPiece(Position.of("f2")));
        board.move("f2", "e4");

        // SSW
        board.move("e4", "d2");
        assertEquals(whiteNight, board.findPiece(Position.of("d2")));
        board.move("d2", "e4");

        // WWS
        board.move("e4", "c3");
        assertEquals(whiteNight, board.findPiece(Position.of("c3")));
        board.move("c3", "e4");

        // WWN
        board.move("e4", "c5");
        assertEquals(whiteNight, board.findPiece(Position.of("c5")));
        board.move("c5", "e4");
    }

    @Test
    @DisplayName("나이트는 같은 팀원이 있는 곳에 도착할 수 없다.")
    public void verifyMovePosition_WhenNightMoveOnTeam_ReturnFalse(){
        board.initializeEmptyBoard();

        Position nightPos = Position.of("e5");
        Position teamPos = Position.of("d3");
        Piece whiteNight = Piece.createWhiteKnight(nightPos);
        Piece whitePawn = Piece.createWhitePawn(teamPos);
        board.setPiece(nightPos, whiteNight);
        board.setPiece(teamPos, whitePawn);

        board.move("e5", "d3");
        assertEquals(whiteNight, board.findPiece(Position.of("e5")));
    }
}
