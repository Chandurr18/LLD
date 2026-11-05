package com.lld.practice.TicTacToe.state;

import com.lld.practice.TicTacToe.exceptions.InvalidMoveException;
import com.lld.practice.TicTacToe.models.Game;
import com.lld.practice.TicTacToe.models.Player;
import com.lld.practice.TicTacToe.state.GameState;

public class DrawState implements GameState {
    @Override
    public void handleMove(Game game, Player player, int row, int col) throws InvalidMoveException {
        throw  new InvalidMoveException("Game is already over. It was a draw.");
    }
}
