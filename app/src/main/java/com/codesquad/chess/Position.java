package com.codesquad.chess;

import java.util.Objects;

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

    public static Position of(int x, int y){
        return new Position(x, y);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Position position = (Position) object;
        return x == position.getX() && y == position.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
