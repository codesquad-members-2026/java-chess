package com.codesquad.chess;

import com.codesquad.chess.piece.Piece;

import java.util.Arrays;

public class ChessGame {
    public boolean canKingPieceMove(Piece piece, Position target, Board board){
        Position current = piece.getPosition();
        int x = current.getX();
        int y = current.getY();

        Position[] positions = new Position[]{
                Position.of(x - 1, y - 1), Position.of(x, y - 1), Position.of(x + 1, y),
                Position.of(x - 1, y), Position.of(x + 1, y),
                Position.of(x - 1, y + 1), Position.of(x, y + 1), Position.of(x + 1, y + 1)
        };

        return Arrays.asList(positions).contains(target) && !isSameColorPiece(piece, target, board);
    }

    private boolean isSameColorPiece(Piece piece, Position target, Board board){
        Piece targetPiece = board.findPiece(target);
        return piece.getColor() == targetPiece.getColor();
    }
}
