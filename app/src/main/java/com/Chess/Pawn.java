package com.Chess;

public class Pawn {
    String color;

    public Pawn(String color){
        this.color = color.toLowerCase();
    }

    public String getColor(){
        return this.color;
    }
}
