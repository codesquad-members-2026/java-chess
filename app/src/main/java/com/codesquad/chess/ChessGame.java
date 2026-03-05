package com.codesquad.chess;

import java.util.Scanner;

public class ChessGame {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userInput = "";

        while(!(userInput.equals("exit"))){
            System.out.print("입력하세요 >>> ");
            userInput = scan.nextLine();
        }
    }
}
