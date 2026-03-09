package com.codesquad.chess;

import com.codesquad.chess.piece.Piece;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codesquad.chess.piece.Piece.*;
import static com.codesquad.chess.utils.StringUtils.appendNewLine;

public class Board {
    private List<Rank> ranks;

    public static final int BOARD_LENGTH = 8;
    public static final String FILE_STR = "abcdefgh";

    public Board(){
        ranks = new ArrayList<>();
    }

    public int pieceCount(){
        return ranks.stream().mapToInt(Rank::size).sum();
    }

    public void initialize(){
        this.ranks = new ArrayList<>();

        // 검은색 기물 추가
        addBlackPieces();
        // 빈칸 4줄 추가
        AddFourRowBlanks();
        // 하얀색 기물 추가
        addWhitePieces();
    }
    public void initializeEmptyBoard(){
        AddFourRowBlanks();
        AddFourRowBlanks();
    }
    private void addBlackPieces(){
        Rank rank = new Rank();

        // 검은색 기물 추가
        // 폰 X
        rank.add(createBlackRook());
        rank.add(createBlackKnight());
        rank.add(createBlackBishop());
        rank.add(createBlackQueen());
        rank.add(createBlackKing());
        rank.add(createBlackBishop());
        rank.add(createBlackKnight());
        rank.add(createBlackRook());
        this.ranks.add(rank);

        // 폰 O
        rank = new Rank();
        for(int i = 0; i < BOARD_LENGTH; i++){
            rank.add(createBlackPawn());
        }
        this.ranks.add(rank);
    }
    private void AddFourRowBlanks(){
        // 중간 빈칸 추가
        final int BOARD_LEN_HALF = BOARD_LENGTH / 2;
        for(int i = 0; i < BOARD_LEN_HALF; i++){
            Rank rank = new Rank();

            for(int j = 0; j < BOARD_LENGTH; j++){
                rank.add(createBlank());
            }

            this.ranks.add(rank);
        }
    }
    private void addWhitePieces(){
        // 하얀색 기물 추가
        Rank rank = new Rank();
        for(int i = 0; i < BOARD_LENGTH; i++){
            rank.add(createWhitePawn());
        }
        this.ranks.add(rank);

        rank = new Rank();
        rank.add(createWhiteRook());
        rank.add(createWhiteKnight());
        rank.add(createWhiteBishop());
        rank.add(createWhiteQueen());
        rank.add(createWhiteKing());
        rank.add(createWhiteBishop());
        rank.add(createWhiteKnight());
        rank.add(createWhiteRook());
        this.ranks.add(rank);
    }

    public String showBoard(){
        StringBuilder result = new StringBuilder();
        int len = ranks.size();

        for(int i = 0; i < len; i++){
            result.append(appendNewLine(ranks.get(i).toString() + "  " + (len - i)));
        }

        result.append(appendNewLine(""));
        result.append(appendNewLine(FILE_STR));

        return result.toString();
    }

    public int checkPieceNum(Piece piece, String inputBoard){
        char representation = piece.getRepresentation();
        List<String> splitsList = Arrays.asList(inputBoard.split("\n"));
        return Math.toIntExact(splitsList.stream().mapToLong(s -> s.chars().filter(c -> representation == c).count()).sum());
    }

    public Piece findPiece(String position){
        Position pos = Position.of(position);
        return ranks.get(pos.getY()).get(pos.getX());
    }

    public void move(String position, Piece piece){
        Position pos = Position.of(position);
        ranks.get(pos.getY()).set(pos.getX(), piece);
    }

    public double calculatePoint(Color color){
        int rankLen = ranks.size();
        double sum = 0.0;

        for(int i = 0; i < rankLen; i++){
            int fileLen = ranks.get(i).size();
            Rank rank = ranks.get(i);

            for(int j = 0; j < fileLen; j++){
                Piece piece = rank.get(j);

                if(color == piece.getColor()){
                    if(piece.getType() == Type.PAWN){
                        sum += calculatePawnPoint(j, i, piece);
                        continue;
                    }

                    sum += piece.getPoint();
                }
            }
        }

        return sum;
    }

    private double calculatePawnPoint(int fileIdx, int rankIdx, Piece pawn){
        double pawnPoint = Type.PAWN.getPoint();

        int rankLen = ranks.size();
        for(int i = 0; i < rankLen && i != rankIdx; i++){
            Piece piece = ranks.get(i).get(fileIdx);

            if((pawn.getType() == piece.getType()) && (pawn.getColor() == piece.getColor()))
                return pawnPoint / 2;
        }

        return pawnPoint;
    }
}
