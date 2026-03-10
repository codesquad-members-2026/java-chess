package chess;

import chess.pieces.Blank;
import chess.pieces.Color;
import chess.pieces.Pawn;
import chess.pieces.Type;
import java.util.ArrayList;
import java.util.List;

import chess.pieces.Piece;


public class Board {
    public static final int SIZE = 8;
    private final List<Rank> board = new ArrayList<>();

    private int pieceCount = 0;

    public void initialize() {
        board.add(Rank.fillWithMajorPieces(Color.WHITE));
        board.add(Rank.fillWithPawns(Color.WHITE));
        for (int i = 0; i < 4; i++) {
            board.add(Rank.emptyRank());
        }
        board.add(Rank.fillWithPawns(Color.BLACK));
        board.add(Rank.fillWithMajorPieces(Color.BLACK));

        pieceCount = 32;
    }

    public void initializeEmpty() {
        for (int i = 0; i < SIZE; i++) {
            board.add(Rank.emptyRank());
        }
    }


    public int pieceCount() {
        return pieceCount;
    }

    public Rank getRank(int rank) {
        return board.get(rank);
    }

//    public int countPieces(Color color, Type type) {
//        int count = 0;
//        for (Rank rank : board) {
//            count += rank.countPieces(color, type);
//        }
//        return count;
//    }

    public Piece findPiece(Position position) {
        return board.get(position.rank).get(position.file);
    }


    public void move(Piece piece, Position from, Position to) {
        board.get(from.rank).set(Blank.getBlank(), from.file);
        board.get(to.rank).set(piece, to.file);

        if (piece instanceof Pawn pawn) {
            pawn.moved();
            // 프로모션 코드 작성하기
        }
    }

    public double calculatePoint(Color color) {
        int[] pawnCountPerFile = new int[SIZE];
        double point = 0;

        for (int r = 0; r < SIZE; r++) {
            for (int f = 0; f < SIZE; f++) {
                Piece piece = board.get(r).get(f);

                if (piece.getColor() != color) {
                    continue;
                }

                Type type = piece.getType();
                if (type == Type.PAWN) {
                    pawnCountPerFile[f]++;
                } else {
                    point += type.getDefaultPoint();
                }
            }
        }

        return point + calculatePawnPoint(pawnCountPerFile);
    }

    private double calculatePawnPoint(int[] pawnCountPerFile) {
        double pawnPoint = Type.PAWN.getDefaultPoint();
        double point = 0;

        for (int file = 0; file < SIZE; file++) {
            int count = pawnCountPerFile[file];
            if (count >= 2) {
                point += count * pawnPoint / 2;
            } else {
                point += count * pawnPoint;
            }
        }
        return point;
    }
}
