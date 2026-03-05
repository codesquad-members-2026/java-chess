package com.codesquad.chess.utils;

public class StringUtils {
    private StringUtils() {}

    // public static final String NEWLINE = System.lineSeparator()
    public static final String NEWLINE = System.getProperty("line.separator");

    public static String appendNewLine(String input){
        return input + NEWLINE;
    }
}