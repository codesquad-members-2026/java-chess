package com.codesquad.chess;

import com.codesquad.chess.piece.Piece;

import java.util.*;

import static com.codesquad.chess.piece.Piece.*;

public class Board {
    private List<Rank> ranks;
    private ChessGame game;

    public static final int BOARD_LENGTH = 8;

    public Board(){
        ranks = new ArrayList<>();
        game = new ChessGame();
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

    // 남아있는 기물의 수 계산
    public int pieceCount(){
        return ranks.stream().mapToInt(Rank::size).sum();
    }
    public int checkPieceNum(Piece piece, String inputBoard){
        char representation = piece.getRepresentation();
        List<String> splitsList = Arrays.asList(inputBoard.split("\n"));
        return Math.toIntExact(splitsList.stream().mapToLong(s -> s.chars().filter(c -> representation == c).count()).sum());
    }

    // 기물 이동을 위한 메서드들
    public Piece findPiece(Position pos){
        return ranks.get(pos.getY()).get(pos.getX());
    }
    public void move(String source, String target){
        Piece originPiece = findPiece(Position.of(source));
        addPiece(source, Piece.createBlank(Position.of(source)));

        originPiece.changePosition(Position.of(target));
        addPiece(target, originPiece);
    }
    private void addPiece(String position, Piece piece){
        Position pos = Position.of(position);
        ranks.get(pos.getY()).set(pos.getX(), piece);
    }

    // 남아있는 기물의 점수 계산 메서드들
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
    public List<Piece> orderPieceList(Color color, Comparator<Piece> sortRule){
        return ranks.stream().flatMap(r -> r.getStream().filter(p -> p.getColor() == color))
                .sorted(sortRule)
                .toList();
    }

    public List<Rank> getRanks(){
        return ranks;
    }
}
