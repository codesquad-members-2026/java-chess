package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import chess.Board;
import chess.Game;
import chess.io.InputHandler;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import java.io.ByteArrayInputStream;
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

//    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
//        assertTrue(whitePiece.isWhite());
//        assertEquals(type, whitePiece.getType());
//
//        assertTrue(blackPiece.isBlack());
//        assertEquals(type, blackPiece.getType());
//    }

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

//    @Test
//    public void getRepresentationPerPiece() throws Exception {
//        assertEquals('♙', Piece.Type.PAWN.getWhiteRepresentation());
//        assertEquals('♟', Piece.Type.PAWN.getBlackRepresentation());
//    }

    @Test
    public void test1() {
        //String input = "move e7 e6\nquit\n";
        String input = "move e2 e3\nquit\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));


        InputHandler inputHandler = new InputHandler();
        inputHandler.run();

        Game game = inputHandler.game;
        Board board = game.getBoard();

        Piece piece = board.getRank(0).get(4);
        System.out.println(piece.getValidMoves(board));
    }

}