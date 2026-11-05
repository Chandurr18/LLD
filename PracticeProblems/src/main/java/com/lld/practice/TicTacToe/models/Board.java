package com.lld.practice.TicTacToe.models;

import com.lld.practice.TicTacToe.enums.Symbol;
import com.lld.practice.TicTacToe.exceptions.InvalidMoveException;
import lombok.Getter;

public class Board {
    private final Cell[][] board;

    @Getter
    private int movesCount;

    @Getter
    private final int size;

    public Board(int size) {
        if (size < 1) throw new IllegalArgumentException("Board size must be positive");

        this.size = size;
        this.movesCount = 0;
        this.board = new Cell[size][size];

        initializeBoard();
    }

    private void initializeBoard() {
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                board[row][col] = new Cell(row, col);
            }
        }
    }

    public boolean isFull() {
        return movesCount == (size * size);
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    public Symbol getSymbol(int row, int col) throws InvalidMoveException {
        validateCoordinates(row, col);
        return getCell(row, col).getSymbol();
    }

    public boolean placeSymbol(int row, int col, Symbol symbol) throws InvalidMoveException {
        validateCoordinates(row, col);
        if (symbol == null || symbol == Symbol.EMPTY)
            throw new InvalidMoveException("A move must contain X or O");
        Cell cell = getCell(row, col);

        if(!cell.isEmpty()) return false;

        cell.setSymbol(symbol);
        movesCount++;
        return true;
    }

    public void printBoard() {
        System.out.println("------- BOARD --------");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("| " + board[i][j].getSymbol().getChar() + " ");
            }
            System.out.println("|");
        }
    }

    private void validateCoordinates(int row, int col) throws InvalidMoveException {
        if (row < 0 || row >= size || col < 0 || col >= size)
            throw new InvalidMoveException("Position is outside the board: (" + row + ", " + col + ")");
    }
}
