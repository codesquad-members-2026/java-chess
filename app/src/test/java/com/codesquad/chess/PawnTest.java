package com.codesquad.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    @DisplayName("폰 생성 및 색깔 일치 체크")
    public void create_매개변수가있는생성자(){
        verifyPawn("black");
        verifyPawn("white");
    }

    private void verifyPawn(final String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("색이 없는 Pawn 생성")
    public void create_기본생성자() throws Exception{
        Pawn pawn = new Pawn();

        // 왜 컴파일 에러가 생기는가?
        /*
            애초에 매개변수가 없는 기본생성자를 Pawn 클래스에서 따로 만들지 않았기 때문이다.
            요구사항대로 색이 없는 Pawn(기본생성자)을 생성하는 경우, 기본으로 흰색 말을 생성하도록 Pawn에 두 번째 생성자를 추가했다.
         */
        assertEquals("white", pawn.getColor());
    }
}
