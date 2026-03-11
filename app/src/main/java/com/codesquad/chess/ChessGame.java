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

        if(sourcePiece.getType() == Piece.Type.KING) {
            if(!kingMoving(sourcePos, targetPos)) {
                System.out.println("ERROR : King's Moving is ERROR.");
                return;
            }
        }



        Piece targetPiece = board.findPiece(targetPos);
        if (sourcePiece.getColor() == targetPiece.getColor()) {
            System.out.println("Error: There is a same color Object.");
            return;
        }

        board.setPiece(targetPos, sourcePiece);
        board.setPiece(sourcePos, Piece.createBlank());


    }

    private boolean kingMoving(Position sourcePos, Position targetPos) {
        int KingX = Math.abs(targetPos.getX() - sourcePos.getX());
        int KingY = Math.abs(targetPos.getY() - sourcePos.getY());

        return (KingX <= 1 && KingY <= 1) && !(KingX == 0 && KingY == 0);
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
