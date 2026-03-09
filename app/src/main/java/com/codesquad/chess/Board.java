package com.codesquad.chess;

import com.codesquad.chess.piece.Piece;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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
        rank.add(Piece.createBlackRook());
        rank.add(Piece.createBlackKnight());
        rank.add(Piece.createBlackBishop());
        rank.add(Piece.createBlackQueen());
        rank.add(Piece.createBlackKing());
        rank.add(Piece.createBlackBishop());
        rank.add(Piece.createBlackKnight());
        rank.add(Piece.createBlackRook());
        this.ranks.add(rank);

        // 폰 O
        rank = new Rank();
        for(int i = 0; i < BOARD_LENGTH; i++){
            rank.add(Piece.createBlackPawn());
        }
        this.ranks.add(rank);
    }

    private void AddFourRowBlanks(){
        // 중간 빈칸 추가
        final int BOARD_LEN_HALF = BOARD_LENGTH / 2;
        for(int i = 0; i < BOARD_LEN_HALF; i++){
            Rank rank = new Rank();

            for(int j = 0; j < BOARD_LENGTH; j++){
                rank.add(Piece.createBlank());
            }

            this.ranks.add(rank);
        }
    }

    private void addWhitePieces(){
        // 하얀색 기물 추가
        Rank rank = new Rank();
        for(int i = 0; i < BOARD_LENGTH; i++){
            rank.add(Piece.createWhitePawn());
        }
        this.ranks.add(rank);

        rank = new Rank();
        rank.add(Piece.createWhiteRook());
        rank.add(Piece.createWhiteKnight());
        rank.add(Piece.createWhiteBishop());
        rank.add(Piece.createWhiteQueen());
        rank.add(Piece.createWhiteKing());
        rank.add(Piece.createWhiteBishop());
        rank.add(Piece.createWhiteKnight());
        rank.add(Piece.createWhiteRook());
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
}
