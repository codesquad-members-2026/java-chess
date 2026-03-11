package com.codesquad.chess.piece;

import com.codesquad.chess.Board;
import com.codesquad.chess.ChessView;
import com.codesquad.chess.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codesquad.chess.utils.StringUtils.appendNewLine;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KingTest {

    private Board board;

    @BeforeEach
    void setUp(){
        board = new Board();
    }

    @Test
    @DisplayName("빈 체스판 구현 테스트")
    public void createEmptyChessBoard(){
        board.initializeEmptyBoard();

        String expectedBoard =
                appendNewLine("........  8") +
                appendNewLine("........  7") +
                appendNewLine("........  6") +
                appendNewLine("........  5") +
                appendNewLine("........  4") +
                appendNewLine("........  3") +
                appendNewLine("........  2") +
                appendNewLine("........  1") +
                appendNewLine("") +
                appendNewLine("abcdefgh");


        assertEquals(expectedBoard, ChessView.showBoard(board.getRanks()));
    }

    @Test
    @DisplayName("King은 모든 방향으로 한 칸씩 이동할 수 있어야 한다.")
    public void verifyMovePosition_EveryDirections(){
        board.initializeEmptyBoard();

        Piece king = Piece.createWhiteKing(Position.of("e1"));
        board.setPiece(Position.of("e1"), king);

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

    @Test
    @DisplayName("King의 이동 장소에 같은 색깔의 기물이 존재하면 이동이 거부되어 제자리에 머문다.")
    public void verifyMovePosition_SameColorPiece_MoveRejected(){
        board.initializeEmptyBoard();

        Piece king = Piece.createWhiteKing(Position.of("e1"));
        Piece pawn = Piece.createWhitePawn(Position.of("e2"));
        board.setPiece(Position.of("e1"), king);
        board.setPiece(Position.of("e2"), pawn);

        board.move("e1", "e2");
        assertEquals(king, board.findPiece(Position.of("e1")));
        assertEquals(pawn, board.findPiece(Position.of("e2")));
    }
}
