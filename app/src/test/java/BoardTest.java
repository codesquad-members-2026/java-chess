import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.StringUtils.appendNewLine;

import chess.Board;
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

    @Test
    public void create() throws Exception {
        board.initialize();

        assertEquals(32, board.pieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("♖♘♗♕♔♗♘♖")+
                        appendNewLine("♙♙♙♙♙♙♙♙") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("♟♟♟♟♟♟♟♟") +
                        appendNewLine("♜♞♝♛♚♝♞♜") ,
                        board.showBoard());
    }

    @Test
    @DisplayName("체스판에 폰 이외의 객체 추가")
    public void addNonPawn() {
        //board.add(Integer.valueOf(7)); 컴파일 에러
    }

    @Test
    @DisplayName("기물과 색에 해당하는 기물의 개수를 반환")
    public void count() {
        board.initialize();

        assertEquals(8, board.countPieces(Color.WHITE, Type.PAWN));
        assertEquals(8, board.countPieces(Color.BLACK, Type.PAWN));
        assertEquals(32, board.countPieces(Color.NOCOLOR, Type.NO_PIECE));
        assertEquals(1, board.countPieces(Color.BLACK, Type.KING));
        assertEquals(1, board.countPieces(Color.BLACK, Type.QUEEN));
    }

    @Test
    @DisplayName("체스판 좌표로 기물 반환")
    public void findPiece() throws Exception {
        board.initialize();

        assertEquals(Piece.createBlackRook(), board.findPiece("a8"));
        assertEquals(Piece.createBlackRook(), board.findPiece("h8"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("a1"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("h1"));
    }

    @Test
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertEquals(piece, board.findPiece(position));
        System.out.println(board.showBoard());
    }

    @Test
    public void calculatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        assertEquals(15.0, board.calculatePoint(Color.BLACK), 0.01);
        assertEquals(7.0, board.calculatePoint(Color.WHITE), 0.01);

        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }
}
