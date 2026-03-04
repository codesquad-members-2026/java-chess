package com.codesquad.chess;

import static com.codesquad.chess.ChessConstant.*;

public class Pawn {
    private final String color;

    public Pawn(){
        this.color = WHITE;
    }

    public Pawn(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
