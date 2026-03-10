package com.codesquad.chess;

import com.codesquad.chess.pieces.Piece;

public class ChessGame {
    private static final int SIZE = 8;
    private final Board board;

    public ChessGame() {
        this.board = new Board();
    }

    public void initialize() {
        board.initialize();
    }

    public  void move(String sourcePosition, String targetPosition) {
        Position sourcePos = new Position(sourcePosition);
        Position targetPos = new Position(targetPosition);

        Piece sourcePiece = board.findPiece(sourcePos);

        board.setPiece(targetPos, sourcePiece);
        board.setPiece(sourcePos, Piece.createBlank());
    }

    public double calculatePoint(Piece.Color color) {
        double totalPoint = 0;
        for (Rank rank : board.getRanks()) {
            for (int i = 0; i < SIZE; i++) {
                Piece piece = rank.getPiece(i);
                if (piece.getColor() == color) totalPoint += piece.getPoint();
            }
        }
        for (int x = 0; x < SIZE; x++) {
            int pawnCount = 0;
            for (int y = 0; y < SIZE; y++) {
                Piece piece = board.getRanks().get(y).getPiece(x);
                if (piece.getColor() == color && piece.getType() == Piece.Type.PAWN) pawnCount++;
            }
            if (pawnCount > 1) totalPoint -= (pawnCount * 0.5);
        }
        return totalPoint;
    }

    public Board getBoard() {
        return board;
    }
}
