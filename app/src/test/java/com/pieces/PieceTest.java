package com.pieces;


import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;


public class PieceTest {

    private void verifyColor(final Piece piece, final String color){
        assertThat(piece.getColor()).isEqualTo(color);
    }

    @Test
    public void color_test(){
        verifyColor(Piece.createWhitePawn(), Piece.WHITE_COLOR);
        verifyColor(Piece.createBlackPawn(), Piece.BLACK_COLOR);
        verifyColor(Piece.createWhiteKing(), Piece.WHITE_COLOR);
        verifyColor(Piece.createBlackKing(), Piece.BLACK_COLOR);
        verifyColor(Piece.createWhiteQueen(), Piece.WHITE_COLOR);
        verifyColor(Piece.createBlackQueen(), Piece.BLACK_COLOR);
        verifyColor(Piece.createWhiteRook(), Piece.WHITE_COLOR);
        verifyColor(Piece.createBlackRook(), Piece.BLACK_COLOR);
        verifyColor(Piece.createWhiteKnight(), Piece.WHITE_COLOR);
        verifyColor(Piece.createBlackKnight(), Piece.BLACK_COLOR);
        verifyColor(Piece.createWhiteBishop(), Piece.WHITE_COLOR);
        verifyColor(Piece.createBlackBishop(), Piece.BLACK_COLOR);
    }


    @Test
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);
        verifyPiece(Piece.createWhiteKing(), Piece.WHITE_COLOR, Piece.WHITE_KING_REPRESENTATION);
        verifyPiece(Piece.createBlackKing(), Piece.BLACK_COLOR, Piece.BLACK_KING_REPRESENTATION);
        verifyPiece(Piece.createWhiteQueen(), Piece.WHITE_COLOR, Piece.WHITE_QUEEN_REPRESENTATION);
        verifyPiece(Piece.createBlackQueen(), Piece.BLACK_COLOR, Piece.BLACK_QUEEN_REPRESENTATION);
        verifyPiece(Piece.createWhiteRook(), Piece.WHITE_COLOR, Piece.WHITE_ROOK_REPRESENTATION);
        verifyPiece(Piece.createBlackRook(), Piece.BLACK_COLOR, Piece.BLACK_ROOK_REPRESENTATION);
        verifyPiece(Piece.createWhiteKnight(), Piece.WHITE_COLOR, Piece.WHITE_KNIGHT_REPRESENTATION);
        verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);
        verifyPiece(Piece.createWhiteBishop(), Piece.WHITE_COLOR, Piece.WHITE_BISHOP_REPRESENTATION);
        verifyPiece(Piece.createBlackBishop(), Piece.BLACK_COLOR, Piece.BLACK_BISHOP_REPRESENTATION);

    }

    private void verifyPiece(final Piece piece, final String color, final char representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }
}

