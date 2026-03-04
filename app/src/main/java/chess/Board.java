package chess;

import java.util.ArrayList;
import java.util.List;

import chess.pieces.Piece;

import static utils.StringUtils.appendNewLine;

public class Board {
    private static final char EMPTY_SQUARE = '.';
    private static final int SIZE = 8;
    private final List<Piece> board = new ArrayList<>();
    private final List<Piece> whitePawns = new ArrayList<>();
    private final List<Piece> blackPawns = new ArrayList<>();

    public void initialize() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Piece pawn = null;
                if (row == 1) {
                    pawn = Piece.createWhitePawn();
                    whitePawns.add(pawn);
                } else if (row == 6) {
                    pawn = Piece.createBlackPawn();
                    blackPawns.add(pawn);
                }
                add(pawn);
            }
        }
    }

    public void add(Piece pawn) {
        board.add(pawn);
    }

    public int size() {
        return board.size();
    }

    public Piece findPawn(int index) {
        return board.get(index);
    }

    private String getPawnsResult(List<Piece> pawns) {
        StringBuilder sb = new StringBuilder();
        for (Piece whitePawn : pawns) {
            sb.append(whitePawn.getRepresentation());
        }
        return sb.toString();
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < SIZE; row++) {
            StringBuilder rowSb = new StringBuilder();
            for (int col = 0; col < SIZE; col++) {
                Piece pawn = board.get(row * SIZE + col);
                char representation = pawn == null ? EMPTY_SQUARE : pawn.getRepresentation();
                rowSb.append(representation);
            }
            sb.append(appendNewLine(rowSb.toString()));
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
