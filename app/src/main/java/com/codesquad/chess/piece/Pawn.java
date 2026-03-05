package com.codesquad.chess.piece;

public class Pawn {
    private final String color;
    private final String representation;

    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final String WHITE_REPRESENTATION = "\u2659";
    public static final String BLACK_REPRESENTATION = "\u265F";

    public Pawn(){
        this.color = WHITE_COLOR;
        this.representation = WHITE_REPRESENTATION;
    }

    public Pawn(String color){
        this.color = color;
        this.representation = color.equals("white") ? WHITE_REPRESENTATION : BLACK_REPRESENTATION;
    }

    public Pawn(String color, String rep){
        this.color = color;
        this.representation = rep;
    }

    public String getColor() {
        return color;
    }

    public String getRepresentation() {
        return representation;
    }
}
