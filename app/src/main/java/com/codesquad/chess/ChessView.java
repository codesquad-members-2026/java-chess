package com.codesquad.chess;

public class ChessView {

    public static String showBoard(Board board) {
        StringBuilder sb = new StringBuilder();

        for (Rank rank : board.getRanks()) {
            sb.append(rank.getRankRepresentation()).append("\n");
        }
        return sb.toString();
    }
}
