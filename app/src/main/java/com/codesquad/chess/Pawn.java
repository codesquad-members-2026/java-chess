package com.codesquad.chess;

public class Pawn {
    // 요구사항: 흰색("white")과 검은색("black")을 상수로 정의
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";

    private final String color;

    public Pawn() {
        this.color = WHITE_COLOR;
    }

    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}