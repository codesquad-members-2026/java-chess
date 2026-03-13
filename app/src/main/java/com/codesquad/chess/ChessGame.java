package com.codesquad.chess;

import com.codesquad.chess.pieces.Piece;

public class ChessGame {
    private final Board board;
    private Piece.Color currentTurn;

    public ChessGame() {
        this.board = new Board();
        this.currentTurn = Piece.Color.WHITE;

    }

    public void initialize() {
        board.initialize();
    }

    public  void move(String sourcePosition, String targetPosition) {
        Position sourcePos = new Position(sourcePosition);
        Position targetPos = new Position(targetPosition);

        Piece sourcePiece = board.findPiece(sourcePos);

        if (sourcePiece.getColor() != currentTurn) {
            System.out.println("ERROR. It's " + currentTurn + "'s turn now.");
            return;
        }

        if (sourcePiece.getType() == Piece.Type.NO_PIECE) {
            System.out.println("ERROR. 선택한 위치에 기물이 없습니다.");
            return;
        }

        if (!sourcePiece.canMove(sourcePos, targetPos, board)) {
            System.out.println("ERROR. 움직임이 올바르지 않습니다.");
            return;
        }

        Piece targetPiece = board.findPiece(targetPos);
        if (sourcePiece.getColor() == targetPiece.getColor()) {
            System.out.println("ERROR. 같은 색의 기물이 있습니다.");
            return;
        }

        board.setPiece(targetPos, sourcePiece);
        board.setPiece(sourcePos, Piece.createBlank());

        changeTurn();
    }

    public Board getBoard() {
        return board;
    }

    private void changeTurn() {
        currentTurn = (currentTurn == Piece.Color.WHITE) ? Piece.Color.BLACK : Piece.Color.WHITE;
    }
}
