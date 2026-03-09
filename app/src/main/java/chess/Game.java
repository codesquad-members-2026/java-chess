package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.Type;
import java.util.Set;

public class Game {
    // 검증이나 계산은 game이 board는 최종 작업만
    private final Board board;

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

        Set<Position> validMoves = piece.getValidMoves(board);

        Position to = Position.from(targetStr);
        if (!validMoves.contains(to)) {
            throw new IllegalStateException("해당 위치로 움직일 수 없음");
        }

        board.move(piece, from, to);
    }

    public Board getBoard() {
        return board;
    }
}
