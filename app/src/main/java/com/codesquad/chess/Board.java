package com.codesquad.chess;
import java.util.ArrayList;
import java.util.List;
import pieces.Pawn;

public class Board {

    private List<Pawn> whitePawns = new ArrayList<>();
    private List<Pawn> blackPawns = new ArrayList<>();

    public void initialize() {
        whitePawns.clear();
        blackPawns.clear();

        for (int i = 0; i < 8; i++) {
            whitePawns.add(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
            blackPawns.add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        }
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        String blankLine = "........";
        String newLine = System.getProperty("line.separator");

        sb.append(blankLine).append(newLine);
        sb.append(getBlackPawnsResult()).append(newLine);
        sb.append(blankLine).append(newLine).append(blankLine).append(newLine);
        sb.append(blankLine).append(newLine).append(blankLine).append(newLine);
        sb.append(getWhitePawnsResult()).append(newLine);
        sb.append(blankLine).append(newLine);

        return sb.toString();
    }

    String getWhitePawnsResult() {
        return getPawnsResult(whitePawns);
    }

    String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }

    private String getPawnsResult(List<Pawn> pawns) {
        StringBuilder sb = new StringBuilder();
        for (Pawn pawn : pawns) {
            sb.append(pawn.getRepresentation());
        }
        return sb.toString();
    }

    public int size() {
        // 흰색 폰 8개 + 검은색 폰 8개 = 총 16개가 나오도록 합쳐줍니다.
        return whitePawns.size() + blackPawns.size();
    }
}