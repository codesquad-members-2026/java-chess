package com.codesquad.chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();

        System.out.println("체스 게임을 시작합니다.");
        System.out.println("시작: start, 종료: end");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine().toLowerCase();

            if (command.equals("start")) {
                board.initializeEmpty();
                System.out.println(board.showBoard());
                continue;
            }

            if (command.equals("end")) {
                System.out.println("게임을 종료합니다.");
                break;
            }

            System.out.println("지원하지 않는 명령어입니다. 'start' 또는 'end'를 입력하세요.");
        }
        scanner.close();
    }
}