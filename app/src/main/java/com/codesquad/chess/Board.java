package com.codesquad.chess;

import com.codesquad.chess.piece.Piece;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.codesquad.chess.utils.StringUtils.appendNewLine;

public class Board {
    private List<Rank> pieces;

    public static final int PAWN_NUM = 8;
    public static final int BOARD_LENGTH = 8;

    public Board(){
        pieces = new ArrayList<Rank>();
    }

    public int pieceCount(){
        for(Rank r : pieces){
            System.out.println(r.toString());
        }

        return pieces.size() * pieces.get(0).size();
    }

    public void initialize(){
        ArrayList<Piece> rank = new ArrayList<>();
        // 검은색 기물 추가
        rank.add(Piece.createBlackRook());
        rank.add(Piece.createBlackKnight());
        rank.add(Piece.createBlackBishop());
        rank.add(Piece.createBlackQueen());
        rank.add(Piece.createBlackKing());
        rank.add(Piece.createBlackBishop());
        rank.add(Piece.createBlackKnight());
        rank.add(Piece.createBlackRook());
        pieces.add(new Rank(rank));
        rank = new ArrayList<>();

        for(int i = 0; i < BOARD_LENGTH; i++){
            rank.add(Piece.createBlackPawn());
        }
        pieces.add(new Rank(rank));


        // 중간 빈칸 추가
        for(int i = 0; i < BOARD_LENGTH / 2; i++){
            rank = new ArrayList<>();

            for(int j = 0; j < BOARD_LENGTH; j++){
                rank.add(Piece.createBlank());
            }

            pieces.add(new Rank(rank));
        }

        // 하얀색 기물 추가
        rank = new ArrayList<>();
        for(int i = 0; i < BOARD_LENGTH; i++){
            rank.add(Piece.createWhitePawn());
        }
        pieces.add(new Rank(rank));

        rank = new ArrayList<>();
        rank.add(Piece.createWhiteRook());
        rank.add(Piece.createWhiteKnight());
        rank.add(Piece.createWhiteBishop());
        rank.add(Piece.createWhiteQueen());
        rank.add(Piece.createWhiteKing());
        rank.add(Piece.createWhiteBishop());
        rank.add(Piece.createWhiteKnight());
        rank.add(Piece.createWhiteRook());
        pieces.add(new Rank(rank));
    }

    public String showBoard(){
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < BOARD_LENGTH; i++){
            result.append(appendNewLine(pieces.get(i).toString()));
        }

        return result.toString();
    }
}
