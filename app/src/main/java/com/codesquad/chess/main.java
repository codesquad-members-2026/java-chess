package com.codesquad.chess;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board board = new Board();

        System.out.println("게임을 시작할려면 start, 게임을 종료할려면 end를 입력하시오");

        while (true) {
            System.out.print("> ");
            String command = sc.nextLine();

            if (command.equals("start")) {
                board.initialize();
                System.out.println(board.showBoard());
                continue;
            }

            if (command.equals("end")) {
                System.out.println("게임을 종료합니다.");
                break;
            }

            System.out.println("알 수 없는 명령어입니다. start 또는 end를 입력하세요.");
        }

        sc.close();
    }
}