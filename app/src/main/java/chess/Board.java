package chess;

import java.util.ArrayList;
import java.util.List;

import chess.pieces.Pawn;

public class Board {
    private static final char EMPTY_SQUARE = '.';
    private final List<Pawn> board = new ArrayList<>();
    private final List<Pawn> whitePawns = new ArrayList<>();
    private final List<Pawn> blackPawns = new ArrayList<>();

    public void initialize() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Pawn pawn = null;
                if (row == 1) {
                    pawn = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
                    whitePawns.add(pawn);
                } else if (row == 6) {
                    pawn = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
                    blackPawns.add(pawn);
                }
                board.add(pawn);
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
}
