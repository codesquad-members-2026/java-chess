package com.codesquad.chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Pawn> WhitePawns = new ArrayList<>();
    private List<Pawn> BlackPawns = new ArrayList<>();

    public void addWhite(Pawn pawn) {
        WhitePawns.add(pawn);
    }

    public void addBlack(Pawn pawn) {
        BlackPawns.add(pawn);
    }

    public int size() {
        return WhitePawns.size() + BlackPawns.size();
    }

    public Pawn findPawn(int index) {
        return WhitePawns.get(index);
    }

    public void initialize() {
        for(int i = 0; i < 8; i++) {
            addWhite(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
            addBlack(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        }
    }
}
