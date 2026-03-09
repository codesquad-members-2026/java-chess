package chess;

import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Piece.*;
import chess.pieces.Color;
import chess.pieces.Type;
import java.util.Set;

public class Game {
    // 검증이나 계산은 game이 board는 최종 작업만
    private final Board board;
    private Color currentTurn = Color.WHITE;

    public Game() {
        board = new Board();
        board.initialize();
    }

    public void move(String sourceStr, String targetStr) {
        Position from = Position.from(sourceStr);
        Piece piece = board.findPiece(from);

        if (piece.getType() == Type.NO_PIECE) {
            throw new IllegalStateException("빈 칸을 선택하였음");
        }

        if (piece.getColor() != currentTurn) {
            throw new IllegalStateException("자신의 색이 아닌 기물은 이동할 수 없음");
        }

        Set<Position> validMoves = piece.getValidMoves(from, board);

        Position to = Position.from(targetStr);
        if (!validMoves.contains(to)) {
            throw new IllegalStateException("해당 위치로 움직일 수 없음");
        }

        board.move(piece, from, to);
        switchTurn();
    }

    public Board getBoard() {
        return board;
    }

    public void switchTurn() {
        if (currentTurn == Color.WHITE) {
            currentTurn = Color.BLACK;
        } else {
            currentTurn = Color.WHITE;
        }
    }

    public void init() {
        board.initialize();
        currentTurn = Color.WHITE;
    }
}
