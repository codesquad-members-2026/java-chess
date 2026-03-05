package com.codesquad.chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board board = new Board();

        System.out.println("Chess Game Start: [start] / Exit: [end]");

        while (true) {
            System.out.print("> ");
            if (!sc.hasNextLine()) break;

            String command = sc.nextLine();

            if (command.equals("start")) {
                board.initialize();
                System.out.println(board.showBoard());
            } else if (command.equals("end")) {
                System.out.println("End Game.");
                break;
            } else {
                System.out.println("명령어를 다시 입력해주세요.");
            }
        }
        sc.close();
    }
}