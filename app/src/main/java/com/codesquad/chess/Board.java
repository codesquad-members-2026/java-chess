package com.codesquad.chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Pawn> whitePawns = new ArrayList<>();
    private List<Pawn> blackPawns = new ArrayList<>();

    public void addWhite(Pawn pawn) {
        whitePawns.add(pawn);
    }

    public void addBlack(Pawn pawn) {
        blackPawns.add(pawn);
    }

    public int size() {
        return whitePawns.size() + blackPawns.size();
    }

    public Pawn findPawn(int index) {
        return whitePawns.get(index);
    }

    public void initialize() {
        for(int i = 0; i < 8; i++) {
            addWhite(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
            addBlack(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        }
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }

    private String getPawnsResult(List<Pawn> pawns) {
        StringBuilder sb = new StringBuilder();
        for(Pawn pawn : pawns) {
            sb.append(pawn.getRepresentation());
        }
        return sb.toString();
    }
}
