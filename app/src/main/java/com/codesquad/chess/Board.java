package com.codesquad.chess;

import com.codesquad.chess.piece.Pawn;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pawn> pawns;

    public Board(){
        pawns = new ArrayList<>();
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

    }

    public void print(){

    }
}
