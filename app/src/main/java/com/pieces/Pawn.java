package com.pieces;

public class Pawn {
    public static final int WHITE_COLOR = 1;
    public static final int BLACK_COLOR = 0;

    int color; // 0 - black , 1 - white

    public Pawn(){
        this.color = WHITE_COLOR;
    }

    public Pawn(String color){

        if(color.equalsIgnoreCase("white")){
            this.color = WHITE_COLOR;
        }
        else{
            this.color = BLACK_COLOR;
        }

    }

    public Pawn(int color){
        this.color = color;
    }

    public String getColor(){
        return switch(this.color){
            case 1 -> "white";
            default -> "black";
        };
    }
}
