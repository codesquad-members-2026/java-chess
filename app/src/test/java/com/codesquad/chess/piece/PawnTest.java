package com.codesquad.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    @DisplayName("색이 없는 Pawn 생성")
    public void create_기본생성자() throws Exception{
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE_COLOR, pawn.getColor());
        assertEquals(Pawn.WHITE_REPRESENTATION, pawn.getRepresentation());
    }

    @Test
    @DisplayName("폰 생성 및 색깔 일치 체크")
    public void create_매개변수가있는생성자(){
        verifyPawn(Pawn.WHITE_COLOR);
        verifyPawn(Pawn.BLACK_COLOR);
        verifyPawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
    }

    private void verifyPawn(final String color){
        Pawn pawn = new Pawn(color);
        String rep = color.equals("white") ? Pawn.WHITE_REPRESENTATION : Pawn.BLACK_REPRESENTATION;
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(pawn.getRepresentation()).isEqualTo(rep);
    }

    private void verifyPawn(final String color, final String rep){
        Pawn pawn = new Pawn(color, rep);
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(pawn.getRepresentation()).isEqualTo(rep);
    }
}
