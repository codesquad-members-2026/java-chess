package com.codesquad.chess;

import java.util.List;

import static com.codesquad.chess.utils.StringUtils.appendNewLine;

public class ChessView {

    public static final String FILE_STR = "abcdefgh";

    private ChessView(){}

    public static String showBoard(List<Rank> ranks){
        StringBuilder result = new StringBuilder();
        int len = ranks.size();

        for(int i = 0; i < len; i++){
            result.append(appendNewLine(ranks.get(i).toString() + "  " + (len - i)));
        }

        result.append(appendNewLine(""));
        result.append(appendNewLine(FILE_STR));

        return result.toString();
    }
}
