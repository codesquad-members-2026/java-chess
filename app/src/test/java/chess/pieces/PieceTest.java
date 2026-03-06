package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import org.junit.jupiter.api.Test;

class PieceTest {
//    @Test
//    public void create_piece() {
//        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN);
//        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT);
//        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK);
//        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP);
//        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN);
//        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING);
//
//        Piece blank = Piece.createBlank();
//        assertFalse(blank.isWhite());
//        assertFalse(blank.isBlack());
//        assertEquals(Type.NO_PIECE, blank.getType());
//    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
    }

//    @Test
//    public void isBlackPiece() {
//        assertTrue(Piece.createBlackBishop().isBlack());
//        assertTrue(Piece.createBlackPawn().isBlack());
//
//        assertFalse(Piece.createWhiteRook().isBlack());
//        assertFalse(Piece.createWhiteKing().isBlack());
//    }
//
//    @Test
//    public void isWhitePiece() {
//        assertTrue(Piece.createWhiteRook().isWhite());
//        assertTrue(Piece.createWhiteKing().isWhite());
//
//        assertFalse(Piece.createBlackBishop().isWhite());
//        assertFalse(Piece.createBlackPawn().isWhite());
//    }

    @Test
    public void getRepresentationPerPiece() throws Exception {
        assertEquals('♙', Piece.Type.PAWN.getWhiteRepresentation());
        assertEquals('♟', Piece.Type.PAWN.getBlackRepresentation());
    }

}