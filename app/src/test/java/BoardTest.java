import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.StringUtils.appendNewLine;

import chess.Board;
import chess.Position;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess.pieces.Piece;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void init() {
        board = new Board();
    }

//    @Test
//    public void create() throws Exception {
//        board.initialize();
//
//        assertEquals(32, board.pieceCount());
//        String blankRank = appendNewLine("........");
//        assertEquals(
//                appendNewLine("♖♘♗♕♔♗♘♖")+
//                        appendNewLine("♙♙♙♙♙♙♙♙") +
//                        blankRank + blankRank + blankRank + blankRank +
//                        appendNewLine("♟♟♟♟♟♟♟♟") +
//                        appendNewLine("♜♞♝♛♚♝♞♜") ,
//                        board.showBoard());
//    }

    @Test
    @DisplayName("체스판에 폰 이외의 객체 추가")
    public void addNonPawn() {
        //board.add(Integer.valueOf(7)); 컴파일 에러
    }

//    @Test
//    @DisplayName("기물과 색에 해당하는 기물의 개수를 반환")
//    public void count() {
//        board.initialize();
//
//        assertEquals(8, board.countPieces(Color.WHITE, Type.PAWN));
//        assertEquals(8, board.countPieces(Color.BLACK, Type.PAWN));
//        assertEquals(32, board.countPieces(Color.NOCOLOR, Type.NO_PIECE));
//        assertEquals(1, board.countPieces(Color.BLACK, Type.KING));
//        assertEquals(1, board.countPieces(Color.BLACK, Type.QUEEN));
//    }
//
//    @Test
//    @DisplayName("체스판 좌표로 기물 반환")
//    public void findPiece() throws Exception {
//        board.initialize();
//
//        assertEquals(Piece.createBlackRook(Position.from("a8")), board.findPiece("a8"));
//        assertEquals(Piece.createBlackRook(Position.from("h8")), board.findPiece("h8"));
//        assertEquals(Piece.createWhiteRook(Position.from("a1")), board.findPiece("a1"));
//        assertEquals(Piece.createWhiteRook(Position.from("h1")), board.findPiece("h1"));
//    }
//
//    @Test
//    public void move() throws Exception {
//        board.initialize();
//
//        String sourcePosition = "b2";
//        String targetPosition = "b3";
//        board.move(sourcePosition, targetPosition);
//        assertEquals(Piece.createBlank(Position.from(sourcePosition)), board.findPiece(sourcePosition));
//        assertEquals(Piece.createWhitePawn(Position.from(targetPosition)), board.findPiece(targetPosition));
//    }
}
