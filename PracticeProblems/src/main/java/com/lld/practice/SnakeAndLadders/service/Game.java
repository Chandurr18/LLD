package com.lld.practice.SnakeAndLadders.service;

import com.lld.practice.SnakeAndLadders.enums.ObstacleType;
import com.lld.practice.SnakeAndLadders.factory.ObstacleFactory;
import com.lld.practice.SnakeAndLadders.model.Board;
import com.lld.practice.SnakeAndLadders.model.Dice;
import com.lld.practice.SnakeAndLadders.model.Obstacle;
import com.lld.practice.SnakeAndLadders.model.Player;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class Game {
    private final int noOfSnakes;
    private final int noOfLadders;
    private final int size;
    private final int noOfDice;

    private final Board board;
    private final Queue<Player> players;
    private final Dice dice;
    private final ArrayList<Player> leaderBoard;

    public Game(int size, int noOfLadders, int noOfSnakes, int noOfDice){
        this.size = size;
        this.noOfDice = noOfDice;
        this.noOfLadders = noOfLadders;
        this.noOfSnakes = noOfSnakes;

        board = new Board(size);
        players = new ArrayDeque<>();
        dice = new Dice(noOfDice);

        leaderBoard = new ArrayList<>();

        initBoardObstacles();
    }

    public void initBoardObstacles(){
        generateObstacles(noOfSnakes, ObstacleType.SNAKE);
        generateObstacles(noOfLadders, ObstacleType.LADDER);
    }

    public void generateObstacles(int count, ObstacleType obstacleType){
        Random random = new Random();

        while(count > 0){
            int up = random.nextInt(size - 1) + 2;
            int down = random.nextInt(up - 1) + 1;
            System.out.println("--trying to add at " + up + " : " + down);

            Obstacle obstacle = ObstacleFactory.createObstacle(obstacleType, up, down);
            if(board.addObstacle(obstacle)){
                System.out.println("-- adding " + obstacleType + " : " + (count));
                board.printBoard(players);
                count--;
            }
        }
    }

    public  void addPlayer(Player player){
        players.add(player);
    }

    public void startGame(){
        board.printBoard(players);

        while (players.size() > 1){
            Player curPlayer = players.poll();
            System.out.println("----------------------------------");

            int diceRoll = dice.roll();
            System.out.println(curPlayer.getName() + " rolled " + diceRoll);

            int newPosition = board.getNewPostion(curPlayer, diceRoll);

            if(newPosition == curPlayer.getPosition()){
                players.offer(curPlayer);
                continue;
            }

            curPlayer.setPosition(newPosition);
            if(newPosition == size){
                System.out.println(curPlayer.getName() + " has won the game! ");
                leaderBoard.add(curPlayer);
            } else {
                players.offer(curPlayer);
            }

            board.printBoard(players);
        }

        Player curPlayer = players.poll();

        if(curPlayer != null) leaderBoard.add(curPlayer);

        printLeaderBoard();
    }

    public void printLeaderBoard(){
        System.out.println("-------------- LEADER BOARD --------------");

        for(int i = 0; i < leaderBoard.size(); i++){
            System.out.println((i + 1) + " : " + leaderBoard.get(i).getName());
        }
    }
}
