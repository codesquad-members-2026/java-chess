package com.pieces;

public class Pawn {
    public static final int WHITE_COLOR = 1;
    public static final int BLACK_COLOR = 0;
    public static final char WHITE_REPRESENTATION = 'P';
    public static final char BLACK_REPRESENTATION = 'p';

    private char representationCharacter;
    private int color; // 0 - black , 1 - white

    public Pawn(){
        this.color = WHITE_COLOR;
        this.representationCharacter = WHITE_REPRESENTATION;
    }

    public Pawn(String color){

        if(color.equalsIgnoreCase("white")){
            this.color = WHITE_COLOR;
            this.representationCharacter = WHITE_REPRESENTATION;
        }
        else{
            this.color = BLACK_COLOR;
            this.representationCharacter = BLACK_REPRESENTATION;
        }

    }

    public Pawn(String color, final char representation){
        this(color);
        this.representationCharacter=representation;
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

    public char getRepresentation(){
        return this.representationCharacter;
    }
}
