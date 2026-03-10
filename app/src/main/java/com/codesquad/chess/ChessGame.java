package com.codesquad.chess;

import java.util.Scanner;

public class ChessGame {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Board board = new Board();
        String line = "";
        board.initialize();

        while(!line.equals("exit")){
            System.out.println(board.showBoard());

            System.out.print(">>> ");
            line = scan.nextLine();
            String[] inputs = line.split(" ");
            String command = inputs[0].trim();
            String source = inputs[1].trim();
            String target = inputs[2].trim();

            switch (command) {
                case "move" -> board.move(source, target);
                default -> System.out.println("Invalid command");
            }
        }
    }
}
