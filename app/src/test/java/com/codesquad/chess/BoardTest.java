package com.codesquad.chess;

import com.codesquad.chess.piece.Piece;
import com.codesquad.chess.Position.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codesquad.chess.utils.StringUtils.appendNewLine;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Board 객체 테스트")
public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp(){
        board = new Board();
    }

    @Test
    @DisplayName("초기화 메서드 실행 후 기물의 종류와 빈칸을 포함한 공간의 개수 일치 테스트")
    public void createInitialChessBoard(){
        board.initialize();
        assertEquals(64, board.pieceCount());

        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR  8") +
                appendNewLine("PPPPPPPP  7") +
                appendNewLine("........  6") +
                appendNewLine("........  5") +
                appendNewLine("........  4") +
                appendNewLine("........  3") +
                appendNewLine("pppppppp  2") +
                appendNewLine("rnbqkbnr  1") +
                appendNewLine("") +
                appendNewLine("abcdefgh"),
                ChessView.showBoard(board.getRanks()));
    }

    @Test
    @DisplayName("주어진 위치의 기물을 조회한다.")
    public void checkPieceLocation(){
        board.initialize();

        // --- 1. Black Pieces (Rank 8) ---
        assertEquals(Piece.createBlackRook(Position.of("a8")), board.findPiece(Position.of("a8")));
        assertEquals(Piece.createBlackKnight(Position.of("b8")), board.findPiece(Position.of("b8")));
    }

    @Test
    @DisplayName("체스판에 존재하는 기물을 이동시킨다")
    public void addPieceOnEmptyBoard(){
        board.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        board.move(sourcePosition, targetPosition);
        assertEquals(Piece.createBlank(Position.of(sourcePosition)), board.findPiece(Position.of(sourcePosition)));
        assertEquals(Piece.createWhitePawn(Position.of(targetPosition)), board.findPiece(Position.of(targetPosition)));
    }
}
