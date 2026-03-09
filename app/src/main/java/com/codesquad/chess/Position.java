package com.codesquad.chess;

public class Position {

    private int x;
    private int y;

    public Position(String position) {
        this.x = position.charAt(0) - 'a';
        this.y = y - Character.getNumericValue(position.charAt(1));
    }

    public int getX() {return x;}
    public int getY() {return y;}

}
