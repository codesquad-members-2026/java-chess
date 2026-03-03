import static org.junit.jupiter.api.Assertions.assertEquals;

import chess.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess.pieces.Pawn;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void init() {
        board = new Board();
    }

    @Test
    public void create() throws Exception {
        verifyAddPawn(new Pawn(Pawn.WHITE_COLOR), 1);
        verifyAddPawn(new Pawn(Pawn.BLACK_COLOR), 2);
        verifyAddPawn(new Pawn(Pawn.WHITE_COLOR), 3);
    }

    private void verifyAddPawn(Pawn pawn, int boardSize) {
        board.add(pawn);
        assertEquals(boardSize, board.size());
        assertEquals(pawn, board.findPawn(boardSize - 1));
    }

    @Test
    @DisplayName("체스판에 폰 이외의 객체 추가")
    public void addNonPawn() {
        //board.add(Integer.valueOf(7)); 컴파일 에러
    }
}
