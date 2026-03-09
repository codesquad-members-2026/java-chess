package com.codesquad.chess;

public class Position {
    private final int x;
    private final int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position of(String position) {
        char[] coordinates = position.toCharArray();
        int x = coordinates[0] - 'a';
        int y = Board.BOARD_LENGTH - Character.getNumericValue(coordinates[1]);

        return new Position(x, y);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
