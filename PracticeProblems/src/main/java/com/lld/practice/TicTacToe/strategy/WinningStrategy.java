package com.lld.practice.TicTacToe.strategy;

import com.lld.practice.TicTacToe.exceptions.InvalidMoveException;
import com.lld.practice.TicTacToe.models.Board;
import com.lld.practice.TicTacToe.models.Cell;
import com.lld.practice.TicTacToe.models.Player;

public interface WinningStrategy {
    boolean checkWinner(Board board, Player player) throws InvalidMoveException;
}
