package com.codesquad.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codesquad.chess.utils.ChessConstant.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {

    @Test
    @DisplayName("Piece의 Type 열거형 값 비교")
    public void getRepresentationPerPiece(){
        assertEquals('p', Piece.Type.PAWN.getWhiteRepresentation());
        assertEquals('P', Piece.Type.PAWN.getBlackRepresentation());
    }
}
