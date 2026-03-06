package com.codesquad.chess;

import com.codesquad.chess.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private List<Piece> rank;

    public Rank(){
        rank = new ArrayList<>();
    }

    public Rank(List<Piece> rank){
        this.rank = rank;
    }

    public int size(){
        return rank.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < rank.size(); i++){
            result.append(rank.get(i).getRepresentation());
        }

        return result.toString();
    }
}
