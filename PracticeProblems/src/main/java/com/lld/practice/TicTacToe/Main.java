package com.lld.practice.TicTacToe;

import com.lld.practice.TicTacToe.enums.Symbol;
import com.lld.practice.TicTacToe.models.Player;
import com.lld.practice.TicTacToe.observer.GameEventPublisher;
import com.lld.practice.TicTacToe.service.GameService;
import com.lld.practice.TicTacToe.strategy.ColWinningStrategy;
import com.lld.practice.TicTacToe.strategy.DiagonalWinningStrategy;
import com.lld.practice.TicTacToe.strategy.RowWinningStrategy;

public class Main {
    public static void main(String[] args) {
        GameService gameService = new GameService();

        Player alice = new Player("p1", "Alice", Symbol.X);
        Player bob = new Player("p2", "Bob", Symbol.O);

        // --- GAME 1: Alice wins ---
        System.out.println("--- GAME 1: Alice (X) vs. Bob (O) ---");
        gameService.createGame("game1", alice, bob);
        gameService.printBoard();

        gameService.makeMove(alice, 0, 0);
        gameService.makeMove(bob, 1, 0);
        gameService.makeMove(alice, 0, 1);
        gameService.makeMove(bob, 1, 1);
        gameService.makeMove(alice, 0, 2); // Alice wins, scoreboard is notified
        System.out.println("----------------------------------------\n");

        // --- GAME 2: Bob wins ---
        System.out.println("--- GAME 2: Alice (X) vs. Bob (O) ---");
        gameService.createGame("game2", alice, bob); // A new game instance
        gameService.printBoard();

        gameService.makeMove(alice, 0, 0);
        gameService.makeMove(bob, 1, 0);
        gameService.makeMove(alice, 0, 1);
        gameService.makeMove(bob, 1, 1);
        gameService.makeMove(alice, 2, 2);
        gameService.makeMove(bob, 1, 2); // Bob wins, scoreboard is notified
        System.out.println("----------------------------------------\n");

//        // --- GAME 3: A Draw ---
        System.out.println("--- GAME 3: Alice (X) vs. Bob (O) - Draw ---");
        gameService.createGame("game3", alice, bob);
        gameService.printBoard();

        gameService.makeMove(alice, 0, 0);
        gameService.makeMove(bob, 0, 1);
        gameService.makeMove(alice, 0, 2);
        gameService.makeMove(bob, 1, 1);
        gameService.makeMove(alice, 1, 0);
        gameService.makeMove(bob, 1, 2);
        gameService.makeMove(alice, 2, 1);
        gameService.makeMove(bob, 2, 0);
        gameService.makeMove(alice, 2, 2); // Draw, scoreboard is not notified of a winner
        System.out.println("----------------------------------------\n");

        // --- Final Scoreboard ---
        // We get the scoreboard from the gameService and print its final state
        gameService.printScoreBoard();
    }
}
