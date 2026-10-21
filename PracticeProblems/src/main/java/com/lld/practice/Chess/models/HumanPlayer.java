package com.lld.practice.Chess.models;

import com.lld.practice.Chess.enums.Color;
import com.lld.practice.Chess.enums.PlayerType;

import java.util.Scanner;

public class HumanPlayer extends  Player{
    private final Scanner input = new Scanner(System.in);

    public HumanPlayer(String name, Color color){
        super(name, color);
    }

    @Override
    public PlayerType getPlayerType() {
        return PlayerType.HUMAN;
    }

    @Override
    public String[] decideMove(Board board) {
        System.out.print("Enter your move (e.g., a2 a4): ");
        return new String[]{input.next(), input.next()};
    }
}
