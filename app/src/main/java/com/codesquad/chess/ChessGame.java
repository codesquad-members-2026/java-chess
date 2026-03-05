package com.codesquad.chess;

import java.util.Scanner;

public class ChessGame {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Board board = new Board();
        board.initialize();
        System.out.println(board.showBoard());
    }
}
