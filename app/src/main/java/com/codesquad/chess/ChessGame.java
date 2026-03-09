package com.codesquad.chess;

import java.util.Scanner;

public class ChessGame {
    static void main(String[] args) {
        Board board = new Board();
        board.initialize();
        System.out.println(board.showBoard());
    }
}
