package com.lld.practice.TicTacToe.state;

import com.lld.practice.TicTacToe.exceptions.InvalidMoveException;
import com.lld.practice.TicTacToe.models.Game;
import com.lld.practice.TicTacToe.models.Player;

public class WinnerState implements GameState{
    @Override
    public void handleMove(Game game, Player player, int row, int col) throws InvalidMoveException {
        throw new InvalidMoveException("Game is already over. " + game.getWinnerPlayer().getName() + " has won.");
    }
}
