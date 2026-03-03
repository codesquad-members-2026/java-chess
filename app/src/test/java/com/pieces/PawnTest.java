package com.pieces;


import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;


public class PawnTest {

//     void verifyPawn(final String color){
//        Pawn newPawn = new Pawn(color);
//        assertThat(newPawn.getColor()).isEqualTo(color);
//    }

    @DisplayName("Verify if pawn spawns with correct color")
    @Test
    public void create(){
        verifyPawn("white", Pawn.WHITE_REPRESENTATION);
        verifyPawn("black", Pawn.BLACK_REPRESENTATION);
    }

    @Test
    public void create_defaultConstructor() throws Exception{
         Pawn p = new Pawn();
         assertThat(p.getColor()).isEqualTo("white");
         assertThat(p.getRepresentation()).isEqualTo(Pawn.WHITE_REPRESENTATION);
    }


void verifyPawn(final String color, final char representation) {
        Pawn pawn = new Pawn(color, representation);
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(pawn.getRepresentation()).isEqualTo(representation);
    }
}
