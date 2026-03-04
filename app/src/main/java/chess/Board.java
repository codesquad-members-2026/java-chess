package chess;

import static utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;

import chess.pieces.Piece;


public class Board {
    public static final int SIZE = 8;
    private final List<Rank> board = new ArrayList<>();

    private int pieceCount = 0;

    public void initialize() {
        board.add(Rank.fillWithBlackMajorPieces());
        board.add(Rank.fillWithBlackPawns());

        for (int i = 0; i < 4; i++) {
            board.add(Rank.emptyRank());
        }

        board.add(Rank.fillWithWhitePawns());
        board.add(Rank.fillWithWhiteMajorPieces());

        pieceCount = 32;
    }


    public int pieceCount() {
        return pieceCount;
    }




    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int rankNum = 0; rankNum < SIZE; rankNum++) {
            Rank rank = board.get(rankNum);
            sb.append(appendNewLine(rank.showRank()));
        }
        return sb.toString();
    }
}
