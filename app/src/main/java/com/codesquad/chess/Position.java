package com.codesquad.chess;

public class Position {
    private final int x;
    private final int y;

    public Position(String position) {
        position = position.trim();
        this.x = position.charAt(0) - 'a';
        this.y = Board.SIZE - Character.getNumericValue(position.charAt(1));
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
        // equals를 만들면 hashCode도 세트로 만들어주는 것이 자바의 정석입니다.
        return java.util.Objects.hash(x, y);
    }
}