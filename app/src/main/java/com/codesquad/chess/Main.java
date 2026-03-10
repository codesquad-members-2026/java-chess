package com.codesquad.chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChessGame game = new ChessGame();

        System.out.println("Play Chess Game.");
        System.out.println("start,OR,end");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine().toLowerCase();
            if (command.equals("start")) {
                game.initialize();
                System.out.println(ChessView.showBoard(game.getBoard()));
                continue;
            }

            if (command.startsWith("move")) {
                String[] tokens = command.split(" ");

                if(tokens.length == 3) {
                    game.move(tokens[1], tokens[2]);
                    System.out.println(ChessView.showBoard(game.getBoard()));
                } else {
                    System.out.println("ERROR ex) move b2 b3");
                }
                continue;
            }

            if (command.equals("end")) {
                System.out.println("End Game.");
                break;
            }

            System.out.println("Error.");
        }
        scanner.close();
    }
}