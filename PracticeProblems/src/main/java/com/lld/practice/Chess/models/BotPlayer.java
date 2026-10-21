package com.lld.practice.Chess.models;

import com.lld.practice.Chess.enums.Color;
import com.lld.practice.Chess.enums.PlayerType;
import com.lld.practice.Chess.utils.Utils;

public class BotPlayer extends  Player{
    public BotPlayer(String name, Color color){
        super(name, color);
    }

    @Override
    public PlayerType getPlayerType() {
        return PlayerType.BOT;
    }

    @Override
    public String[] decideMove(Board board) {
        String[] move = Utils.generateRandomMove(board, color);
        System.out.println("Bot move: " + move[0] + " to " + move[1]);
        return move;
    }
}
