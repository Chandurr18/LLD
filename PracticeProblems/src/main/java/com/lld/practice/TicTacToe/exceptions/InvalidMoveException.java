package com.lld.practice.TicTacToe.exceptions;

public class InvalidMoveException extends Throwable{
    public InvalidMoveException(String message) {
        super(message);
    }
}
