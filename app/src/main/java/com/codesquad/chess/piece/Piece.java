package com.codesquad.chess.piece;

import static com.codesquad.chess.ChessConstant.*;

public class Piece {
    private final String color;
    private final String name;

    public Piece(String name){
        this.name = name;
        this.color = WHITE_COLOR;
    }

    public Piece(String color, String name){
        this.color = color;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
