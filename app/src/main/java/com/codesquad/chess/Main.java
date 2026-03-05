package com.codesquad.chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board board = new Board();

        System.out.println("체스 게임을 시작하려면 start, 종료하려면 end를 입력하세요.");

        while (true) {
            System.out.print("> ");

            // Gradle 실행 환경에서 예외가 발생하지 않도록 안전장치 추가
            if (!sc.hasNextLine()) {
                break;
            }

            String command = sc.nextLine();

            if (command.equals("start")) {
                board.initialize(); // 보드 초기화 (폰 16개 배치)
                System.out.print(board.showBoard()); // 현재 보드 출력
                continue;
            }

            if (command.equals("end")) {
                System.out.println("게임을 종료합니다. 수고하셨습니다.");
                break;
            }

            System.out.println("알 수 없는 명령어입니다. 'start' 또는 'end'를 입력해주세요.");
        }

        sc.close();
    }
}