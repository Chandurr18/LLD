package com.lld.practice.TicTacToe.service;

import com.lld.practice.TicTacToe.exceptions.InvalidMoveException;
import com.lld.practice.TicTacToe.models.Game;
import com.lld.practice.TicTacToe.models.Player;
import com.lld.practice.TicTacToe.observer.GameEventPublisher;
import com.lld.practice.TicTacToe.observer.GameObserver;
import com.lld.practice.TicTacToe.observer.ScoreBoardObserver;
import com.lld.practice.TicTacToe.strategy.ColWinningStrategy;
import com.lld.practice.TicTacToe.strategy.DiagonalWinningStrategy;
import com.lld.practice.TicTacToe.strategy.RowWinningStrategy;
import com.lld.practice.TicTacToe.strategy.WinningStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class GameService {
    @Getter
    private Game game;
    private GameEventPublisher gameEventPublisher;
    private final ScoreBoardObserver scoreBoardObserver;

    public GameService() {
        this.scoreBoardObserver = new ScoreBoardObserver();
        this.gameEventPublisher = new GameEventPublisher();

        gameEventPublisher.subscribe(this.scoreBoardObserver);
    }

    public void createGame(String gameId, Player player1, Player player2) {
        this.game = new Game(gameId, player1, player2);
        this.game.setGameEventPublisher(this.gameEventPublisher);

        game.addWinningStrategy(new DiagonalWinningStrategy());
        game.addWinningStrategy(new RowWinningStrategy());
        game.addWinningStrategy(new ColWinningStrategy());
    }

    public void addSubscriber(GameObserver observer) {
        ensureGameCreated();
        gameEventPublisher.subscribe(observer);
    }

    public void removeSubscriber(GameObserver observer) {
        ensureGameCreated();
        gameEventPublisher.unSubscribe(observer);
    }

    public void notifySubscribers() {
        ensureGameCreated();
        gameEventPublisher.notifyAllSubscribers(this.game);
    }

    public void makeMove(Player player, int row, int col){
        ensureGameCreated();

        try {
            System.out.printf("%s plays at (%d, %d)%n", player.getName(), row, col);
            game.makeMove(player, row, col);
            printBoard();
            System.out.println("Game Status: " + game.getGameStatus());
            if (game.getWinnerPlayer() != null) {
                System.out.println("Winner: " + game.getWinnerPlayer().getName());
            }
        } catch (InvalidMoveException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void printBoard() {
        game.getBoard().printBoard();
    }

    private void ensureGameCreated() {
        if (game == null) throw new IllegalStateException("No game created. Create a game first.");
    }

    public void printScoreBoard() {
        scoreBoardObserver.printScores();
    }
}
