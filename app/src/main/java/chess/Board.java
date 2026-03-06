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
        board.add(Rank.fillWithWhiteMajorPieces(0));
        board.add(Rank.fillWithWhitePawns(1));
        for (int i = 2; i < 6; i++) {
            board.add(Rank.emptyRank(i));
        }
        board.add(Rank.fillWithBlackPawns(6));
        board.add(Rank.fillWithBlackMajorPieces(7));

        pieceCount = 32;
    }

    public void initializeEmpty() {
        for (int i = 0; i < SIZE; i++) {
            board.add(Rank.emptyRank(i));
        }
    }


    public int pieceCount() {
        return pieceCount;
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int rankNum = SIZE - 1; rankNum >= 0; rankNum--) {
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

    public void move(String sourceStr, String targetStr) {
        Position sourcePosition = Position.from(sourceStr);
        Rank sourceRank = board.get(sourcePosition.rank);
        Piece sourcePiece = sourceRank.get(sourcePosition.file);

        sourceRank.set(Piece.createBlank(sourcePosition), sourcePosition.file);

        Position targetPosition = Position.from(targetStr);
        Rank targetRank = board.get(targetPosition.rank);
        //Piece targetPiece = targetRank.get(targetPosition.file);
        targetRank.set(sourcePiece, targetPosition.file);
        sourcePiece.move(targetPosition);
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
