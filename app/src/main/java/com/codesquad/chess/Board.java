package com.codesquad.chess;
import com.codesquad.chess.pieces.Piece;
import com.codesquad.chess.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;


public class Board {

    private List<List<Piece>> board = new ArrayList<>();

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            board.add(new ArrayList<Piece>());
        }

        setupBlackPieces();
        setupWhitePieces();
        setupBlankPieces();
    }

    private void setupBlackPieces() {
        List<Piece> rank0 = board.get(0);
        rank0.add(Piece.createBlackRook());
        rank0.add(Piece.createBlackKnight());
        rank0.add(Piece.createBlackBishop());
        rank0.add(Piece.createBlackQueen());
        rank0.add(Piece.createBlackKing());
        rank0.add(Piece.createBlackBishop());
        rank0.add(Piece.createBlackKnight());
        rank0.add(Piece.createBlackRook());

        List<Piece> rank1 = board.get(1);
        for(int i = 0; i < 8; i ++) {
            rank1.add(Piece.createBlackPawn());
        }
    }

    private void setupWhitePieces() {
        List<Piece> rank7 = board.get(7);
        rank7.add(Piece.createWhiteRook());
        rank7.add(Piece.createWhiteKnight());
        rank7.add(Piece.createWhiteBishop());
        rank7.add(Piece.createWhiteQueen());
        rank7.add(Piece.createWhiteKnight());
        rank7.add(Piece.createWhiteBishop());
        rank7.add(Piece.createWhiteKnight());
        rank7.add(Piece.createWhiteRook());

        List<Piece> rank8 = board.get(6);
        for(int i = 0 ; i < 8; i++) {
            rank8.add(Piece.createWhitePawn());
        }
    }

    private void setupBlankPieces() {
        for (int row = 2; row < 6; row++) {
            List<Piece> rank = board.get(row);
            for(int i = 0; i < 8; i++) {
                rank.add(Piece.createBlank());
            }
        }
    }

    public int pieceCount() {
        int count = 0;
        for (List<Piece> rank : board) {
            for(Piece piece : rank) {
                if(piece.getType() != Piece.Type.NO_PIECE) {
                    count++;
                }
            }
        }
        return count;
    }
    public String showBoard() {
        StringBuilder sb = new StringBuilder();

        for(List<Piece> rank : board) {
            for(Piece piece : rank) {
                sb.append(piece.getRepresentation());
            }

            sb.append(StringUtils.NEWLINE);
        }
        return sb.toString();
    }
}