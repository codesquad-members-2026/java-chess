package com.codesquad.chess;

import com.codesquad.chess.piece.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> pawns;
    private List<Pawn> whitePawnsResult;
    private List<Pawn> blackPawnsResult;

    public static final int PAWN_NUM = 8;

    public Board(){
        pawns = new ArrayList<>();
        whitePawnsResult = new ArrayList<>();
        blackPawnsResult = new ArrayList<>();
    }

    public void add(Pawn pawn){
        pawns.add(pawn);
    }

    public int size(){
        return pawns.size();
    }

    public Pawn findPawn(int index){
        return pawns.get(index);
    }

    public void initialize(){
        for(int i = 0; i < PAWN_NUM; i++){
            whitePawnsResult.add(new Pawn(Pawn.WHITE_COLOR));
            blackPawnsResult.add(new Pawn(Pawn.BLACK_COLOR));
        }
    }

    public void print(){

    }

    public String getWhitePawnsResult(){
        StringBuilder result = new StringBuilder();

        for(Pawn p : whitePawnsResult){
            result.append(p.getRepresentation());
        }

        return result.toString();
    }

    public String getBlackPawnsResult(){
        StringBuilder result = new StringBuilder();

        for(Pawn p : blackPawnsResult){
            result.append(p.getRepresentation());
        }

        return result.toString();
    }
}
