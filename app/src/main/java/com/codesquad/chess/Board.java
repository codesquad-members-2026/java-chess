package com.codesquad.chess;

import com.codesquad.chess.piece.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> pawns;

    public static final int PAWN_NUM = 8;
    public static final int BOARD_LENGTH = 8;
    public static final int BLACK_PAWN_ROW = 1;
    public static final int WHITE_PAWN_ROW = 6;
    public static final String EMPTY_SPACE = "\u00B7";

    public Board(){
        pawns = new ArrayList<>();
    }

    public void add(Pawn pawn){
        pawns.add(pawn);
    }

    public int size(){
        return pawns.size();
    }

    public Pawn findPawn(int index){
        return pawns.get(index);
    }

    public void initialize(){
        for(int i = 0; i < PAWN_NUM; i++){
            pawns.add(new Pawn(Pawn.WHITE_COLOR));
            pawns.add(new Pawn(Pawn.BLACK_COLOR));
        }
    }

    public String print(){
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < BOARD_LENGTH; i++){
            if(i == WHITE_PAWN_ROW){
                result.append((Pawn.WHITE_REPRESENTATION + " ").repeat(BOARD_LENGTH));
            }
            else if(i == BLACK_PAWN_ROW) {
                result.append((Pawn.BLACK_REPRESENTATION + " ").repeat(BOARD_LENGTH));
            } else{
                result.append((EMPTY_SPACE + "  ").repeat(BOARD_LENGTH));
            }

            result.append("\n");
        }

        return result.toString();
    }

    public String getWhitePawnsResult(){
        StringBuilder result = new StringBuilder();

        for(Pawn p : pawns){
            if(p.getColor().equals(Pawn.WHITE_COLOR)){
                result.append(p.getRepresentation());
            }
        }

        return result.toString();
    }

    public String getBlackPawnsResult(){
        StringBuilder result = new StringBuilder();

        for(Pawn p : pawns){
            if(p.getColor().equals(Pawn.BLACK_COLOR)){
                result.append(p.getRepresentation());
            }
        }

        return result.toString();
    }
}
