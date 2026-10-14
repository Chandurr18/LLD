package com.lld.practice.SnakeAndLadders.model;

import java.util.Random;

public class Dice {
    private final int noOfDice;
    private final Random random = new Random();

    public Dice(int noOfDice){
        this.noOfDice = noOfDice;
    }

    public int roll() {
        int sum = 0;
        for(int i = 0; i < noOfDice; i++){
            sum += random.nextInt(6) + 1;
        }

        return sum;
    }
}
