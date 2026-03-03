package chess;

import java.util.ArrayList;
import java.util.List;

import chess.pieces.Pawn;

public class Board {
    private final List<Pawn> board = new ArrayList<>();

    public void add(Pawn pawn) {
        board.add(pawn);
    }

    public int size() {
        return board.size();
    }

    public Pawn findPawn(int index) {
        return board.get(index);
    }
}
