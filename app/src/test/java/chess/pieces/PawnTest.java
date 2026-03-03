package chess.pieces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {
    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(chess.pieces.Pawn.WHITE_COLOR);
        verifyPawn(chess.pieces.Pawn.BLACK_COLOR);
    }

    private void verifyPawn(final String color) {
        chess.pieces.Pawn pawn = new chess.pieces.Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }


    @Test
    public void create_기본생성자() throws IOException {
        chess.pieces.Pawn pawn = new chess.pieces.Pawn();
        assertEquals(chess.pieces.Pawn.WHITE_COLOR, pawn.getColor());
    }
}