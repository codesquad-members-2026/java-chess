package com.Chess;
import com.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<Pawn> pawnList = new ArrayList<>();

    public void add(Pawn piece){
        this.pawnList.add(piece);
        this.size ++;
    }

    public int size(){
        return this.size;
    }

    public Pawn findPawn(int index){
        return this.pawnList.get(index);
    }
}
