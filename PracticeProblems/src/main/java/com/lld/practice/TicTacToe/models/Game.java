package com.lld.practice.TicTacToe.models;

import com.lld.practice.TicTacToe.enums.GameStatus;
import com.lld.practice.TicTacToe.exceptions.InvalidMoveException;
import com.lld.practice.TicTacToe.observer.GameEventPublisher;
import com.lld.practice.TicTacToe.state.GameState;
import com.lld.practice.TicTacToe.state.InProgressState;
import com.lld.practice.TicTacToe.strategy.WinningStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final String gameId;
    private final Player player1;
    private final Player player2;
    private final List<WinningStrategy> winningStrategies;


    @Getter
    private final Board board;
    @Getter
    private Player currentPlayer;
    @Getter
    private GameStatus gameStatus;

    @Setter
    private GameEventPublisher gameEventPublisher;
    @Setter
    private GameState state;

    @Getter
    @Setter
    private Player winnerPlayer;

    public Game(String gameId, Player player1, Player player2) {
        if(player1.equals(player2)) {
            throw new IllegalArgumentException("Players must be different");
        }
        if(player1.getSymbol() == player2.getSymbol()) {
            throw  new IllegalArgumentException("Players must have different symbols");
        }

        this.board = new Board(3);
        this.player1 = player1;
        this.player2 = player2;
        this.gameId = gameId;

        this.currentPlayer = player1;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.state = new InProgressState();

        this.winningStrategies = new ArrayList<>();
    }

    public void addWinningStrategy(WinningStrategy winningStrategy) {
        winningStrategies.add(winningStrategy);
    }

    public void switchPlayer() {
        this.currentPlayer = (currentPlayer.equals(player1)) ? player2 : player1;
    }

    public void makeMove(Player player, int row, int col) throws InvalidMoveException {
        state.handleMove(this, player, row, col);
    }

    public boolean checkWinner(Player player) throws InvalidMoveException {
        for(WinningStrategy strategy : winningStrategies) {
            if(strategy.checkWinner(board, player)) {
                return true;
            }
        }

        return false;
    }

    public void setGameStatus(GameStatus status) {
        if(status == null) throw  new IllegalArgumentException("Game status cannot be null.");
        if(this.gameStatus != GameStatus.IN_PROGRESS) {
            throw new IllegalArgumentException("Game is already completed");
        }

        this.gameStatus = status;

        if(status != GameStatus.IN_PROGRESS && gameEventPublisher != null) {
            gameEventPublisher.notifyAllSubscribers(this);
        }
    }
}
