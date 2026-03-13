package com.codesquad.chess.exception;

public class UnreachableDirectionException extends RuntimeException{
    public UnreachableDirectionException(String message){
        super(message);
    }
}
