import static org.junit.jupiter.api.Assertions.assertEquals;

import chess.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess.pieces.Piece;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void init() {
        board = new Board();
        board.initialize();
    }

    @Test
    public void create() throws Exception {
        int size = board.size();
        verifyAddPawn(Piece.createWhitePawn(), size + 1);
        verifyAddPawn(Piece.createBlackPawn(), size + 2);
        verifyAddPawn(Piece.createWhitePawn(), size + 3);
    }

    private void verifyAddPawn(Piece pawn, int boardSize) {
        board.add(pawn);
        assertEquals(boardSize, board.size());
        assertEquals(pawn, board.findPawn(boardSize - 1));
    }

    @Test
    @DisplayName("체스판에 폰 이외의 객체 추가")
    public void addNonPawn() {
        //board.add(Integer.valueOf(7)); 컴파일 에러
    }

    @Test
    public void initialize() throws Exception {
        assertEquals("♙♙♙♙♙♙♙♙", board.getWhitePawnsResult());
        assertEquals("♟♟♟♟♟♟♟♟", board.getBlackPawnsResult());
    }

    @Test
    public void print() {
        String expected = """
                ........
                ♙♙♙♙♙♙♙♙
                ........
                ........
                ........
                ........
                ♟♟♟♟♟♟♟♟
                ........""";
        String actual = board.print();
        assertEquals(expected, actual);
        System.out.println(actual);
    }
}
