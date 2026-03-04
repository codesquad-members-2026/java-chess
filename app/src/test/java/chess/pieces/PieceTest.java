package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PieceTest {
    @Test
    public void create_piece() {
        //pawn
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);

        //knight
        verifyPiece(Piece.createWhiteKnight(), Piece.WHITE_COLOR, Piece.WHITE_KNIGHT_REPRESENTATION);
        verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);

//        //rook
//        verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);
//        verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);
//
//        //bishop
//        verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);
//        verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);
//
//        //queen
//        verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);
//        verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);
//
//        //king
//        verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);
//        verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);

    }

    private void verifyPiece(final Piece piece, final String color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }
}