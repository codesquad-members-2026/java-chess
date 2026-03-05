package com.codesquad.chess;

import com.codesquad.chess.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Piece> pieces;

    public static final int PAWN_NUM = 8;
    public static final int BOARD_LENGTH = 8;
    public static final int BLACK_PAWN_ROW = 1;
    public static final int WHITE_PAWN_ROW = 6;
    public static final String EMPTY_SPACE = "\u00B7";

    public Board(){
        pieces = new ArrayList<>();
    }

    public void add(Piece piece){
        pieces.add(piece);
    }

    public int size(){
        return pieces.size();
    }

    public Piece findPawn(int index){
        return pieces.get(index);
    }

    public void initialize(){
        for(int i = 0; i < PAWN_NUM; i++){
            pieces.add(new Piece(Piece.WHITE_COLOR));
            pieces.add(new Piece(Piece.BLACK_COLOR));
        }
    }

    public String print(){
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < BOARD_LENGTH; i++){
            if(i == WHITE_PAWN_ROW){
                result.append((Piece.WHITE_REPRESENTATION + " ").repeat(BOARD_LENGTH));
            }
            else if(i == BLACK_PAWN_ROW) {
                result.append((Piece.BLACK_REPRESENTATION + " ").repeat(BOARD_LENGTH));
            } else{
                result.append((EMPTY_SPACE + "  ").repeat(BOARD_LENGTH));
            }

            result.append("\n");
        }

        return result.toString();
    }

    public String getWhitePawnsResult(){
        StringBuilder result = new StringBuilder();

        for(Piece p : pieces){
            if(p.getColor().equals(Piece.WHITE_COLOR)){
                result.append(p.getRepresentation());
            }
        }

        return result.toString();
    }

    public String getBlackPawnsResult(){
        StringBuilder result = new StringBuilder();

        for(Piece p : pieces){
            if(p.getColor().equals(Piece.BLACK_COLOR)){
                result.append(p.getRepresentation());
            }
        }

        return result.toString();
    }
}
