package com.codesquad.chess;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board board = new Board();

        System.out.println("Chess Game Start: [start] / Exit: [end]");

        while (true) {
            System.out.print("> ");
            String command = sc.nextLine();

            if (command.equals("start")) {
                board.initialize();
                System.out.println(board.showBoard());
                continue;
            }

            if (command.equals("end")) {
                System.out.println("End Game.");
                break;
            }

            System.out.println("Error.");
        }

        sc.close();
    }
}