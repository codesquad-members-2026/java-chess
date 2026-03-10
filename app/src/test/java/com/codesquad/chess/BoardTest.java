package com.codesquad.chess;

import com.codesquad.chess.piece.Piece;
import com.codesquad.chess.Position.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.codesquad.chess.piece.Piece.*;
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
                board.showBoard());
    }

//    @Test
//    @DisplayName("기물의 종류와 색에 따른 기물의 개수반환")
//    public void checkPieceNum(){
//        String testStr = ".KR.....\n" +
//                "P.PB....\n" +
//                ".P..Q...\n" +
//                "........\n" +
//                ".....nq.\n" +
//                ".....p..\n" +
//                "......p.\n" +
//                "....rk..";
//        Piece piece = createWhitePawn();
//
//        // Black Pawn의 개수는?
//        int result = board.checkPieceNum(piece, testStr);
//
//        assertEquals(2, result);
//    }

//    @Test
//    @DisplayName("주어진 위치의 기물을 조회한다.")
//    public void checkPieceLocation(){
//        board.initialize();
//
//        // --- 1. Black Pieces (Rank 8) ---
//        assertEquals(Piece.createBlackRook(Position.of("a8")), board.findPiece("a8"));
//        assertEquals(Piece.createBlackKnight(Position.of("b8")), board.findPiece("b8"));
//    }

    @Test
    @DisplayName("체스판에 존재하는 기물을 이동시킨다")
    public void addPieceOnEmptyBoard(){
        board.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        board.move(sourcePosition, targetPosition);
        assertEquals(Piece.createBlank(Position.of(sourcePosition)), board.findPiece(sourcePosition));
        assertEquals(Piece.createWhitePawn(Position.of(targetPosition)), board.findPiece(targetPosition));
    }

//    @Test
//    @DisplayName("기물의 수와 종류에 따른 점수 계산")
//    public void calculateScore(){
//        board.initializeEmptyBoard();
//
//        // --- Black Pieces (대문자) ---
//        addPiece("b8", Piece.createBlackKing());
//        addPiece("c8", Piece.createBlackRook());
//        addPiece("a7", Piece.createBlackPawn());
//        addPiece("c7", Piece.createBlackPawn());
//        addPiece("d7", Piece.createBlackBishop());
//        addPiece("b6", Piece.createBlackPawn());
//        addPiece("e6", Piece.createBlackQueen());
//
//        // --- White Pieces (소문자) ---
//        addPiece("f4", Piece.createWhiteKnight());
//        addPiece("g4", Piece.createWhiteQueen());
//        addPiece("f3", Piece.createWhitePawn());
//        addPiece("h3", Piece.createWhitePawn());
//        addPiece("f2", Piece.createWhitePawn());
//        addPiece("g2", Piece.createWhitePawn());
//        addPiece("e1", Piece.createWhiteRook());
//        addPiece("f1", Piece.createWhiteKing());
//
//        assertEquals(20.0, board.calculatePoint(Color.BLACK), 0.01);
//        assertEquals(20.0, board.calculatePoint(Color.WHITE), 0.01);
//
//        System.out.println(board.showBoard());
//    }
//
//    private void addPiece(String position, Piece piece){
//        board.add(position, piece);
//    }
//
//    @Test
//    @DisplayName("하얀색과 검정색 기물을 나눠서 점수가 높은/낮은 순대로 리스트에 저장")
//    public void saveWhiteAndBlackPiecesOrderByPoint(){
//        board.initializeEmptyBoard();
//        List<Piece> whiteExpectedList = new ArrayList<>();
//        List<Piece> blackExpectedList = new ArrayList<>();
//
//        addPiece("f2", Piece.createWhitePawn());
//        addPiece("g2", Piece.createWhitePawn());
//        addPiece("e1", Piece.createWhiteRook());
//        addPiece("f1", Piece.createWhiteKing());
//        whiteExpectedList.add(Piece.createWhiteKing());
//        whiteExpectedList.add(Piece.createWhitePawn());
//        whiteExpectedList.add(Piece.createWhitePawn());
//        whiteExpectedList.add(Piece.createWhiteRook());
//
//        addPiece("b6", Piece.createBlackPawn());
//        addPiece("e6", Piece.createBlackQueen());
//        addPiece("b8", Piece.createBlackKing());
//        addPiece("c8", Piece.createBlackRook());
//        blackExpectedList.add(Piece.createBlackKing());
//        blackExpectedList.add(Piece.createBlackPawn());
//        blackExpectedList.add(Piece.createBlackRook());
//        blackExpectedList.add(Piece.createBlackQueen());
//
//        // 오름차순
//        assertEquals(whiteExpectedList, board.orderPieceList(Color.WHITE, Comparator.comparing(Piece::getPoint)));
//        assertEquals(blackExpectedList, board.orderPieceList(Color.BLACK, Comparator.comparing(Piece::getPoint)));
//
//        // 내림차순
//        whiteExpectedList.sort(Comparator.comparing(Piece::getPoint).reversed());
//        blackExpectedList.sort(Comparator.comparing(Piece::getPoint).reversed());
//
//        assertEquals(whiteExpectedList, board.orderPieceList(Color.WHITE,
//                Comparator.comparing(Piece::getPoint).reversed()));
//        assertEquals(blackExpectedList, board.orderPieceList(Color.BLACK,
//                Comparator.comparing(Piece::getPoint).reversed()));
//    }
}
