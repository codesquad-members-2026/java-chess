package com.codesquad.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PawnTest {

    @Test
    @DisplayName("폰 생성 및 색깔 일치 체크")
    public void createWhitePawn(){
        verifyPawn("black");
        verifyPawn("white");
    }

    private void verifyPawn(final String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
