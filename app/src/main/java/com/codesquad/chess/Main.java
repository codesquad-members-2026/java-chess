package com.codesquad.chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();

        System.out.println("Play Chess Game.");
        System.out.println("start,OR,end");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine().toLowerCase();
            if (command.equals("start")) {
                board.initialize();
                System.out.println(board.showBoard());
                continue;
            }

            if (command.startsWith("move")) {
                String[] tokens = command.split(" ");

                if(tokens.length == 3) {
                    board.move(tokens[1], tokens[2]);
                    System.out.println(board.showBoard());
                } else {
                    System.out.println("ERROR ex) move b2, b3");
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