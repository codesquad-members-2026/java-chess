package com.codesquad.chess.exception;

public class OutOfBoardException extends RuntimeException {
    public OutOfBoardException(String message) {
        super(message);
    }
}
