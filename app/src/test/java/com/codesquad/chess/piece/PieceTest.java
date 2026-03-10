package com.codesquad.chess.piece;

import com.codesquad.chess.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("Piece 객체 생성")
    public void create_piece(){
        verifyPiece(Piece.createWhitePawn(Position.of("a2")), Piece.createBlackPawn(Position.of("a7")), Piece.Type.PAWN);
        verifyPiece(Piece.createWhiteKnight(Position.of("b1")), Piece.createBlackKnight(Position.of("b8")), Piece.Type.KNIGHT);
        verifyPiece(Piece.createWhiteRook(Position.of("a1")), Piece.createBlackRook(Position.of("a8")), Piece.Type.ROOK);
        verifyPiece(Piece.createWhiteBishop(Position.of("c1")), Piece.createBlackBishop(Position.of("c8")), Piece.Type.BISHOP);
        verifyPiece(Piece.createWhiteQueen(Position.of("d1")), Piece.createBlackQueen(Position.of("d8")), Piece.Type.QUEEN);
        verifyPiece(Piece.createWhiteKing(Position.of("e1")), Piece.createBlackKing(Position.of("e8")), Piece.Type.KING);

        Piece blank = Piece.createBlank(Position.of("d4"));
        assertFalse(blank.isWhite());
        assertFalse(blank.isBlack());
        assertEquals(Piece.Type.NO_PIECE, blank.getType());
    }

    public void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Piece.Type type){
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
    }

    @Test
    @DisplayName("Piece의 Type 열거형 값 비교")
    public void getRepresentationPerPiece(){
        assertEquals('p', Piece.Type.PAWN.getWhiteRepresentation());
        assertEquals('P', Piece.Type.PAWN.getBlackRepresentation());
    }


}
