package com.codesquad.chess;

import com.codesquad.chess.piece.Piece;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.codesquad.chess.utils.StringUtils.appendNewLine;

public class Board {
    private List<Piece> pieces;

    public static final int PAWN_NUM = 8;
    public static final int BOARD_LENGTH = 8;

    public Board(){
        pieces = new ArrayList<>();
    }

    public void add(Piece piece){
        pieces.add(piece);
    }

    public int pieceCount(){
        return pieces.size();
    }

    public void initialize(){
        pieces.add(Piece.createBlackRook());
        pieces.add(Piece.createBlackKnight());
        pieces.add(Piece.createBlackBishop());
        pieces.add(Piece.createBlackQueen());
        pieces.add(Piece.createBlackKing());
        pieces.add(Piece.createBlackBishop());
        pieces.add(Piece.createBlackKnight());
        pieces.add(Piece.createBlackRook());

        IntStream.range(0, PAWN_NUM).forEach(i -> {pieces.add(Piece.createBlackPawn());});
        IntStream.range(0, PAWN_NUM).forEach(i -> {pieces.add(Piece.createWhitePawn());});

        pieces.add(Piece.createWhiteRook());
        pieces.add(Piece.createWhiteKnight());
        pieces.add(Piece.createWhiteBishop());
        pieces.add(Piece.createWhiteQueen());
        pieces.add(Piece.createWhiteKing());
        pieces.add(Piece.createWhiteBishop());
        pieces.add(Piece.createWhiteKnight());
        pieces.add(Piece.createWhiteRook());
    }

    public String showBoard(){
        StringBuilder result = new StringBuilder();
        String blankRank = appendNewLine("........");

        for(int i = 0; i < 4; i++){
            StringBuilder line = new StringBuilder();

            if(i == 2){
                int boardHalfLen = BOARD_LENGTH / 2;
                result.append(blankRank.repeat(boardHalfLen));
            }

            for(int j = i * BOARD_LENGTH; j < (i + 1) * BOARD_LENGTH; j++){
                line.append(pieces.get(j).getRepresentation());
            }

            result.append(appendNewLine(line.toString()));
        }

        return result.toString();
    }
}
