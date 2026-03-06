package chess.io;

import static chess.Board.SIZE;
import static utils.StringUtils.appendNewLine;

import chess.Board;
import chess.Rank;

public class ChessView {
    private final Board board;

    public ChessView(Board board) {
        this.board = board;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }


    public void showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int rankNum = SIZE - 1; rankNum >= 0; rankNum--) {
            Rank rank = board.getRank(rankNum);
            sb.append(appendNewLine(showRank(rank)));
        }
        System.out.print(sb);
    }

    private String showRank(Rank rank) {
        StringBuilder sb = new StringBuilder();
        for (int fileNum = 0; fileNum < SIZE; fileNum++) {
            sb.append(rank.get(fileNum).getRepresentation());
        }
        return sb.toString();
    }
}
