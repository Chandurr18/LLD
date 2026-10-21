package com.lld.practice.Chess;

import com.lld.practice.Chess.enums.Color;
import com.lld.practice.Chess.models.BotPlayer;
import com.lld.practice.Chess.models.HumanPlayer;
import com.lld.practice.Chess.models.Player;
import com.lld.practice.Chess.observer.ConsoleSpectator;
import com.lld.practice.Chess.observer.Spectator;
import com.lld.practice.Chess.service.Game;

public class Main {
    public static void main(String[] args) {
        Player player1 = new HumanPlayer("Rakesh", Color.WHITE);
        Player player2 = new BotPlayer("Bot1", Color.BLACK);

        Game game = new Game(player1, player2);

        Spectator s1 = new ConsoleSpectator("Ravi Spectator");
        game.addSpectator(s1);

        game.start();
    }
}
