package chess;

import java.util.ArrayList;
import java.util.List;

import chess.pieces.Pawn;

import static utils.StringUtils.appendNewLine;

public class Board {
    private static final char EMPTY_SQUARE = '.';
    private static final int SIZE = 8;
    private final List<Pawn> board = new ArrayList<>();
    private final List<Pawn> whitePawns = new ArrayList<>();
    private final List<Pawn> blackPawns = new ArrayList<>();

    public void initialize() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Pawn pawn = null;
                if (row == 1) {
                    pawn = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
                    whitePawns.add(pawn);
                } else if (row == 6) {
                    pawn = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
                    blackPawns.add(pawn);
                }
                add(pawn);
            }
        }
    }

    public void add(Pawn pawn) {
        board.add(pawn);
    }

    public int size() {
        return board.size();
    }

    public Pawn findPawn(int index) {
        return board.get(index);
    }

    private String getPawnsResult(List<Pawn> pawns) {
        StringBuilder sb = new StringBuilder();
        for (Pawn whitePawn : pawns) {
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
                Pawn pawn = board.get(row * SIZE + col);
                char representation = pawn == null ? EMPTY_SQUARE : pawn.getRepresentation();
                rowSb.append(representation);
            }
            sb.append(appendNewLine(rowSb.toString()));
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
