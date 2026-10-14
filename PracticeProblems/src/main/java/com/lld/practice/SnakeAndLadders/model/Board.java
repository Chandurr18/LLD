package com.lld.practice.SnakeAndLadders.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Board {
    private final int size;
    private final int sideLength;
    private final Cell[][] grid;

    public Board(int size){
        this.size = size;
        this.sideLength = (int) Math.sqrt(size);
        this.grid = new Cell[sideLength][sideLength];

        int position = 1;
        boolean leftToRight = true;
        for(int i = sideLength - 1; i >= 0; i--){
            if(leftToRight){
                for(int j = 0; j < sideLength; j++){
                    grid[i][j] = new Cell(position++);
                }
            } else{
                for(int j = sideLength - 1; j >= 0; j--){
                    grid[i][j] = new Cell(position++);
                }
            }

            leftToRight = !leftToRight;
        }
    }

    private int getRow(int position){ // position is one-based, row is zero-based.... that's why (position - 1)
        int row = (position - 1) / sideLength;
        return sideLength - 1 - row;
    }

    private int getCol(int position){
        int row = getRow(position);
        int col = (position - 1) % sideLength;
        return (row % 2 == 0) ? col : (sideLength - 1 - col);
    }

    private Cell getCell(int position){
        return grid[getRow(position)][getCol(position)];
    }


    public boolean addObstacle(Obstacle obstacle){
        Cell srcCell = getCell(obstacle.getSource());
        Cell destCell = getCell(obstacle.getDestination());

        if(srcCell.hasObstacle() || destCell.hasObstacle()) return false;

        System.out.println("-- adding at " + srcCell.getPosition());
        srcCell.setObstacle(obstacle);
        return true;
    }

    public int getNewPostion(Player player, int offset){
        int newPosition = player.getPosition() + offset;

        if(newPosition > size){
            System.out.println("You are going out of board! Better luck next time");
            return player.getPosition();
        }

        Cell cell = getCell(newPosition);
        int finalPosition = cell.getFinalPosition();

        if(finalPosition < newPosition){
            System.out.println("Oops! Snake has bitten " + player.getName());
        } else if(finalPosition > newPosition ){
            System.out.println("Congrats!!! " + player.getName() + " moved up through the ladder");
        } else{
            System.out.println(player.getName() + " moved from " + player.getPosition() + " to " + finalPosition);
        }

        return finalPosition;
    }

    public void printBoard(Queue<Player> players) {

        // Map each board position to the players on that cell
        Map<Integer, StringBuilder> playerMap = new HashMap<>();

        for (Player player : players) {
            playerMap
                    .computeIfAbsent(player.getPosition(), k -> new StringBuilder())
                    .append(player.getName())
                    .append(" ");
        }

        System.out.println("\n========== SNAKES & LADDERS ==========\n");

        // Print from top row to bottom row
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {

                Cell cell = grid[i][j];

                int rowFromBottom = sideLength - 1 - i;
                int position;

                if (rowFromBottom % 2 == 0) {
                    position = rowFromBottom * sideLength + j + 1;
                } else {
                    position = rowFromBottom * sideLength
                            + (sideLength - j);
                }

                StringBuilder label = new StringBuilder();

                // Show the cell number
                label.append(position);

                // Show snake or ladder icon
                if (cell.hasObstacle()) {
                    int destination = cell.getFinalPosition();

                    if (destination < position) {
                        label.append(" 🐍");
                    } else if (destination > position) {
                        label.append(" 🪜");
                    }
                }

                // Show players currently on this position
                if (playerMap.containsKey(position)) {
                    label.append(" [")
                            .append(playerMap.get(position).toString().trim())
                            .append("]");
                }

                System.out.printf("| %-18s", label);
            }

            System.out.println("|");
            System.out.println("-".repeat(sideLength * 21));
        }

        System.out.println("\n🐍 = Snake | 🪜 = Ladder");
        System.out.println("[Player names] = Players on that cell\n");
    }
}
