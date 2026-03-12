package com.codesquad.chess;

public class Position {
    private final int x;
    private final int y;
    private final int SIZE = 8;

    public Position(String position) {
        position = position.trim();
        this.x = position.charAt(0) - 'a';
        this.y = Board.SIZE - Character.getNumericValue(position.charAt(1));

        if(!isVaild()) {
            throw new IllegalArgumentException("체스판 범위를 벗어났습니다.");
        }
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() { return x; }
    public int getY() { return y; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y);
    }

    public boolean isVaild() {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }
}