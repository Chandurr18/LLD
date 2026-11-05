package com.lld.practice.TicTacToe.observer;

import com.lld.practice.TicTacToe.models.Game;
import com.lld.practice.TicTacToe.models.Player;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ScoreBoardObserver implements GameObserver{
    private final Map<String, Integer> scores;
    private final Map<String, String> playerNames;

    public ScoreBoardObserver() {
        this.scores = new ConcurrentHashMap<>();
        this.playerNames = new ConcurrentHashMap<>();
    }

    @Override
    public void update(Game game) {
        Player winner = game.getWinnerPlayer();
        if(winner != null) {
            scores.put(winner.getPlayerId(), scores.getOrDefault(winner, 0) + 1);
            playerNames.put(winner.getPlayerId(), winner.getName());
        }
    }

    public void printScores() {
        System.out.println("\n--- Overall Scoreboard ---");
        if (scores.isEmpty()) {
            System.out.println("No games with a winner have been played yet.");
            return;
        }
        scores.forEach((playerId, score) ->
                System.out.printf("Player: %-10s | Wins: %d%n", playerNames.get(playerId), score)
        );
        System.out.println("--------------------------\n");
    }
}
