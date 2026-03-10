package com.codesquad.chess;

public class Position {
    private final int x;
    private final int y;

    public Position(String position) {
        position = position.trim();
        this.x = position.charAt(0) - 'a';
        this.y = Board.SIZE - Character.getNumericValue(position.charAt(1));
    }


    public int getX() { return x; }
    public int getY() { return y; }
}