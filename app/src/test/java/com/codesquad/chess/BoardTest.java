package com.codesquad.chess;

import com.codesquad.chess.piece.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    @DisplayName("기물의 종류와 색에 따른 기물의 개수반환")
    public void checkPieceNum(){
        String testStr = ".KR.....\n" +
                "P.PB....\n" +
                ".P..Q...\n" +
                "........\n" +
                ".....nq.\n" +
                ".....p..\n" +
                "......p.\n" +
                "....rk..";
        Piece piece = createWhitePawn();

        // Black Pawn의 개수는?
        int result = board.checkPieceNum(piece, testStr);

        assertEquals(2, result);
    }

    @Test
    @DisplayName("주어진 위치의 기물을 조회한다.")
    public void checkPieceLocation(){
        board.initialize();

        // --- 1. Black Pieces (Rank 8) ---
        assertEquals(Piece.createBlackRook(), board.findPiece("a8"));
        assertEquals(Piece.createBlackKnight(), board.findPiece("b8"));
        assertEquals(Piece.createBlackBishop(), board.findPiece("c8"));
        assertEquals(Piece.createBlackQueen(), board.findPiece("d8"));
        assertEquals(Piece.createBlackKing(), board.findPiece("e8"));
        assertEquals(Piece.createBlackBishop(), board.findPiece("f8"));
        assertEquals(Piece.createBlackKnight(), board.findPiece("g8"));
        assertEquals(Piece.createBlackRook(), board.findPiece("h8"));

        // --- 2. Black Pawns (Rank 7) ---
        assertEquals(Piece.createBlackPawn(), board.findPiece("a7"));
        assertEquals(Piece.createBlackPawn(), board.findPiece("b7"));
        assertEquals(Piece.createBlackPawn(), board.findPiece("c7"));
        assertEquals(Piece.createBlackPawn(), board.findPiece("d7"));
        assertEquals(Piece.createBlackPawn(), board.findPiece("e7"));
        assertEquals(Piece.createBlackPawn(), board.findPiece("f7"));
        assertEquals(Piece.createBlackPawn(), board.findPiece("g7"));
        assertEquals(Piece.createBlackPawn(), board.findPiece("h7"));

        // --- 3. White Pawns (Rank 2) ---
        assertEquals(Piece.createWhitePawn(), board.findPiece("a2"));
        assertEquals(Piece.createWhitePawn(), board.findPiece("b2"));
        assertEquals(Piece.createWhitePawn(), board.findPiece("c2"));
        assertEquals(Piece.createWhitePawn(), board.findPiece("d2"));
        assertEquals(Piece.createWhitePawn(), board.findPiece("e2"));
        assertEquals(Piece.createWhitePawn(), board.findPiece("f2"));
        assertEquals(Piece.createWhitePawn(), board.findPiece("g2"));
        assertEquals(Piece.createWhitePawn(), board.findPiece("h2"));

        // --- 4. White Pieces (Rank 1) ---
        assertEquals(Piece.createWhiteRook(), board.findPiece("a1"));
        assertEquals(Piece.createWhiteKnight(), board.findPiece("b1"));
        assertEquals(Piece.createWhiteBishop(), board.findPiece("c1"));
        assertEquals(Piece.createWhiteQueen(), board.findPiece("d1"));
        assertEquals(Piece.createWhiteKing(), board.findPiece("e1"));
        assertEquals(Piece.createWhiteBishop(), board.findPiece("f1"));
        assertEquals(Piece.createWhiteKnight(), board.findPiece("g1"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("h1"));
    }

    @Test
    @DisplayName("임의의 기물을 빈 체스판 위에 추가")
    public void addPieceOnEmptyBoard(){
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

        assertEquals(expectedBoard, board.showBoard());


        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertEquals(piece, board.findPiece(position));
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("기물의 수와 종류에 따른 점수 계산")
    public void calculateScore(){
        board.initializeEmptyBoard();

        // --- Black Pieces (대문자) ---
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());
        addPiece("a7", Piece.createBlackPawn());
        addPiece("c7", Piece.createBlackPawn());
        addPiece("d7", Piece.createBlackBishop());
        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());

        // --- White Pieces (소문자) ---
        addPiece("f4", Piece.createWhiteKnight());
        addPiece("g4", Piece.createWhiteQueen());
        addPiece("f3", Piece.createWhitePawn());
        addPiece("h3", Piece.createWhitePawn());
        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        assertEquals(20.0, board.calculatePoint(Color.BLACK), 0.01);
        assertEquals(20.0, board.calculatePoint(Color.WHITE), 0.01);

        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece){
        board.move(position, piece);
    }

    @Test
    @DisplayName("하얀색과 검정색 기물을 나눠서 점수가 높은 순대로 리스트에 저장")
    public void saveWhiteAndBlackPiecesOrderByPoint(){
        board.initializeEmptyBoard();
        List<Piece> whiteExpectedList = new ArrayList<>();
        List<Piece> blackExpectedList = new ArrayList<>();

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());
        whiteExpectedList.add(Piece.createWhiteKing());
        whiteExpectedList.add(Piece.createWhitePawn());
        whiteExpectedList.add(Piece.createWhitePawn());
        whiteExpectedList.add(Piece.createWhiteRook());

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());
        blackExpectedList.add(Piece.createBlackKing());
        blackExpectedList.add(Piece.createBlackPawn());
        blackExpectedList.add(Piece.createBlackRook());
        blackExpectedList.add(Piece.createBlackQueen());

        // 오름차순
        assertEquals(whiteExpectedList, board.orderPieceList(Color.WHITE, Comparator.comparing(Piece::getPoint)));
        assertEquals(blackExpectedList, board.orderPieceList(Color.BLACK, Comparator.comparing(Piece::getPoint)));

        // 내림차순
        whiteExpectedList.sort(Comparator.comparing(Piece::getPoint).reversed());
        blackExpectedList.sort(Comparator.comparing(Piece::getPoint).reversed());

        assertEquals(whiteExpectedList, board.orderPieceList(Color.WHITE,
                Comparator.comparing(Piece::getPoint).reversed()));
        assertEquals(blackExpectedList, board.orderPieceList(Color.BLACK,
                Comparator.comparing(Piece::getPoint).reversed()));
    }
}
