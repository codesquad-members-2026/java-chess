package com.codesquad.chess;

import com.codesquad.chess.piece.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Rank {
    private List<Piece> rank;

    public Rank(){
        rank = new ArrayList<>();
    }

    public void add(Piece p){
        rank.add(p);
    }

    public int size(){
        return rank.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        IntStream.range(0, rank.size()).forEach(i -> result.append(rank.get(i).getRepresentation()));

        return result.toString();
    }
}
