package com.codesquad.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codesquad.chess.ChessConstant.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {

    @Test
    @DisplayName("Piece 객체 생성 테스트")
    public void create_piece(){
        // 폰
        verifyPiece(Piece.createWhitePawn(), WHITE_COLOR, WHITE_CHESS_PAWN);
        verifyPiece(Piece.createBlackPawn(), BLACK_COLOR, BLACK_CHESS_PAWN);
        
        // 킹
        verifyPiece(Piece.createWhiteKing(), WHITE_COLOR, WHITE_CHESS_KING);
        verifyPiece(Piece.createBlackKing(), BLACK_COLOR, BLACK_CHESS_KING);
        
        // 퀸
        verifyPiece(Piece.createWhiteQueen(), WHITE_COLOR, WHITE_CHESS_QUEEN);
        verifyPiece(Piece.createBlackQueen(), BLACK_COLOR, BLACK_CHESS_QUEEN);

        // 룩
        verifyPiece(Piece.createWhiteRook(), WHITE_COLOR, WHITE_CHESS_ROOK);
        verifyPiece(Piece.createBlackRook(), BLACK_COLOR, BLACK_CHESS_ROOK);

        // 비숍
        verifyPiece(Piece.createWhiteBishop(), WHITE_COLOR, WHITE_CHESS_BISHOP);
        verifyPiece(Piece.createBlackBishop(), BLACK_COLOR, BLACK_CHESS_BISHOP);

        // 나이트
        verifyPiece(Piece.createWhiteKnight(), WHITE_COLOR, WHITE_CHESS_KNIGHT);
        verifyPiece(Piece.createBlackKnight(), BLACK_COLOR, BLACK_CHESS_KNIGHT);
    }

    private void verifyPiece(final Piece piece, final String color, final String representation){
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }
}
