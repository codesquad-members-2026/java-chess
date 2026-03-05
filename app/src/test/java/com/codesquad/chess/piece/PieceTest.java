package com.codesquad.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codesquad.chess.ChessConstant.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {

//    @Test
//    @DisplayName("색이 없는 Pawn 생성자 테스트")
//    public void create_기본생성자() {
//        Piece piece = new Piece();
//        assertEquals(Piece.WHITE_COLOR, piece.getColor());
//        assertEquals(Piece.WHITE_REPRESENTATION, piece.getRepresentation());
//    }

    @Test
    @DisplayName("이름만 있는 Pawn/이름과 색깔 모두 있는 Pawn 생성자 테스트")
    public void create_매개변수가있는생성자(){
        // 매개변수가 name만 있는 경우
        verifyPawn(PAWN);
        verifyPawn(PAWN);

        // 매개변수가 color, name인 경우
        verifyPawn(WHITE_COLOR, PAWN);
        verifyPawn(BLACK_COLOR, PAWN);
    }

    private void verifyPawn(final String name){
        Piece piece = new Piece(name);
        assertThat(piece.getColor()).isEqualTo(WHITE_COLOR);
        assertThat(piece.getName()).isEqualTo(name);
    }

    private void verifyPawn(final String color, final String name){
        Piece piece = new Piece(color, name);
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getName()).isEqualTo(name);
    }
}
