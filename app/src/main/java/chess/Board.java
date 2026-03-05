package chess;

import static utils.StringUtils.appendNewLine;

import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import java.util.ArrayList;
import java.util.List;

import chess.pieces.Piece;


public class Board {
    public static final int SIZE = 8;
    private final List<Rank> board = new ArrayList<>();

    private int pieceCount = 0;

    public void initialize() {
        board.add(Rank.fillWithWhiteMajorPieces());
        board.add(Rank.fillWithWhitePawns());
        for (int i = 0; i < 4; i++) {
            board.add(Rank.emptyRank());
        }
        board.add(Rank.fillWithBlackPawns());
        board.add(Rank.fillWithBlackMajorPieces());

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

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int rankNum = 0; rankNum < SIZE; rankNum++) {
            Rank rank = board.get(rankNum);
            sb.append(appendNewLine(rank.showRank()));
        }
        return sb.toString();
    }

    public int countPieces(Color color, Type type) {
        int count = 0;
        for (Rank rank : board) {
            count += rank.countPieces(color, type);
        }
        return count;
    }

    public Piece findPiece(String positionInput) {
        Position position = Position.from(positionInput);
        return board.get(position.rank).get(position.file);
    }

    public void move(String positionInput, Piece piece) {
        Position position = Position.from(positionInput);
        board.get(position.rank).set(piece, position.file);
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
