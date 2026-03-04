package com.codesquad.chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색과 검은색 폰이 올바르게 생성되어야 한다")
    public void create() {

        String white = "white";
        String black = "black";

        verifyPawn(white);
        verifyPawn(black);
    }

    private void verifyPawn(String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("매개변수 없이 생성하면 흰색 폰이 생성되어야 한다")
    public void create_default() {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo("white");
    }

}