package com.codesquad.chess;

import com.codesquad.chess.exception.OutOfBoardException;

import java.util.Scanner;

public class ChessEngine {

    public static void main(String[] args) {
        ChessEngine engine = new ChessEngine();
        engine.run();
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        Board board = new Board();
        board.initialize();

        while (true) {
            System.out.println(ChessView.showBoard(board.getRanks()));
            System.out.print(">>> ");
            String line = scan.nextLine();

            if (line.equals("exit")) {
                System.out.println("체스 게임을 종료합니다.");
                break;
            }

            processInput(line, board);
        }
        scan.close();
    }

    private void processInput(String line, Board board) {
        String[] inputs = line.split(" ");

        if (!isValidFormat(inputs)) {
            System.out.println("잘못된 입력 형식입니다. (예: move a2 a3)");
            return;
        }

        executeCommand(inputs, board);
    }

    private boolean isValidFormat(String[] inputs) {
        return inputs.length == 3;
    }

    private void executeCommand(String[] inputs, Board board) {
        String command = inputs[0].trim();
        String source = inputs[1].trim();
        String target = inputs[2].trim();

        if (command.equals("move")) {
            try{
                board.move(source, target);
            } catch (OutOfBoardException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("알 수 없는 에러입니다: " + e.getMessage());
            }
        } else {
            System.out.println("지원하지 않는 명령어입니다.");
        }
    }
}