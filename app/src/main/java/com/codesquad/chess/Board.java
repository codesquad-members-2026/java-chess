package com.codesquad.chess;

import com.codesquad.chess.piece.Piece;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.codesquad.chess.piece.Piece.*;

public class Board {
    private List<Rank> ranks;

    public static final int BOARD_LENGTH = 8;

    public Board(){
        ranks = new ArrayList<>();
    }

    public void initialize(){
        this.ranks = new ArrayList<>();

        // 검은색 기물 추가
        addBlackPieces();
        // 빈칸 4줄 추가
        addFourRowBlanks();
        // 하얀색 기물 추가
        addWhitePieces();
    }
    private void addBlackPieces(){
        Rank rank = new Rank();

        // 검은색 기물 추가
        // 폰 X
        rank.add(createBlackRook(Position.of("a8")));
        rank.add(createBlackKnight(Position.of("b8")));
        rank.add(createBlackBishop(Position.of("c8")));
        rank.add(createBlackQueen(Position.of("d8")));
        rank.add(createBlackKing(Position.of("e8")));
        rank.add(createBlackBishop(Position.of("f8")));
        rank.add(createBlackKnight(Position.of("g8")));
        rank.add(createBlackRook(Position.of("h8")));
        this.ranks.add(rank);

        // 폰 O
        rank = new Rank();
        final int SEVENTH_ROW = 7;
        for(int i = 0; i < BOARD_LENGTH; i++){
            String position = String.valueOf((char)('a' + i)) + SEVENTH_ROW;
            rank.add(createBlackPawn(Position.of(position)));
        }
        this.ranks.add(rank);
    }
    private void addFourRowBlanks(){
        final int SIXTH_ROW = 6;
        // 중간 빈칸 추가
        for(int i = 0; i < BOARD_LENGTH / 2; i++){
            Rank rank = new Rank();

            for(int j = 0; j < BOARD_LENGTH; j++){
                String position = String.valueOf((char)('a' + j)) + (SIXTH_ROW - i);
                rank.add(createBlank(Position.of(position)));
            }

            this.ranks.add(rank);
        }
    }
    private void addWhitePieces(){
        // 하얀색 기물 추가
        Rank rank = new Rank();
        final int SECOND_ROW = 2;
        for(int i = 0; i < BOARD_LENGTH; i++){
            String position = String.valueOf((char)('a' + i)) + SECOND_ROW;
            rank.add(createWhitePawn(Position.of(position)));
        }
        this.ranks.add(rank);

        rank = new Rank();
        rank.add(createWhiteRook(Position.of("a1")));
        rank.add(createWhiteKnight(Position.of("a2")));
        rank.add(createWhiteBishop(Position.of("a3")));
        rank.add(createWhiteQueen(Position.of("a4")));
        rank.add(createWhiteKing(Position.of("a5")));
        rank.add(createWhiteBishop(Position.of("a6")));
        rank.add(createWhiteKnight(Position.of("a7")));
        rank.add(createWhiteRook(Position.of("a8")));
        this.ranks.add(rank);
    }
    public void initializeEmptyBoard(){
        this.ranks = IntStream.range(0, BOARD_LENGTH).mapToObj(i -> {
            Rank r = new Rank();
            IntStream.range(0, BOARD_LENGTH).forEach(j -> r.add(createBlank(Position.of(j, BOARD_LENGTH - i))));
            return r;
        }).collect(Collectors.toList());
    }

    // 남아있는 기물의 수 계산
    public int pieceCount(){
        return ranks.stream().mapToInt(Rank::size).sum();
    }

    // 기물 이동을 위한 메서드들
    public Piece findPiece(Position pos){
        return ranks.get(pos.getY()).get(pos.getX());
    }
    public void move(String source, String target){
        Position sourcePosition = Position.of(source);
        Position targetPosition = Position.of(target);
        Piece originPiece = findPiece(sourcePosition);
        if(!originPiece.verifyMovePosition(sourcePosition, targetPosition, this)){
            System.out.println("유효하지 않은 이동입니다.");
            return;
        }

        setPiece(sourcePosition, Piece.createBlank(sourcePosition));
        originPiece.changePosition(targetPosition);
        setPiece(targetPosition, originPiece);
    }
    public void setPiece(Position pos, Piece piece){
        ranks.get(pos.getY()).set(pos.getX(), piece);
    }

    public List<Rank> getRanks(){
        return ranks;
    }
}
