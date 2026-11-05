package com.lld.practice.TicTacToe.state;

import com.lld.practice.TicTacToe.enums.GameStatus;
import com.lld.practice.TicTacToe.enums.Symbol;
import com.lld.practice.TicTacToe.exceptions.InvalidMoveException;
import com.lld.practice.TicTacToe.models.Game;
import com.lld.practice.TicTacToe.models.Player;

public class InProgressState implements GameState{
    @Override
    public void handleMove(Game game, Player player, int row, int col) throws InvalidMoveException {
        if(game.getCurrentPlayer() != player) {
            throw  new InvalidMoveException("Not your turn!");
        }

        // place the peice on the board
        if(!game.getBoard().placeSymbol(row, col, player.getSymbol())) {
            throw  new InvalidMoveException("Unable to place " + player.getSymbol() + " at " + row + " & " + col + ". Please try again....");
        }

        if(game.checkWinner(player)) {
            game.setWinnerPlayer(player);
            game.setState(new WinnerState());
            game.setGameStatus(player.getSymbol() == Symbol.X ? GameStatus.WINNER_X : GameStatus.WINNER_O);
        } else if(game.getBoard().isFull()) {
            game.setGameStatus(GameStatus.DRAW);
            game.setState(new DrawState());
        } else {
            game.switchPlayer();
        }
    }
}
