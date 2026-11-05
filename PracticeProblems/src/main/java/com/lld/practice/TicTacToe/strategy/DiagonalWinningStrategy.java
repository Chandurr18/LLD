package com.lld.practice.TicTacToe.strategy;

import com.lld.practice.TicTacToe.enums.Symbol;
import com.lld.practice.TicTacToe.exceptions.InvalidMoveException;
import com.lld.practice.TicTacToe.models.Board;
import com.lld.practice.TicTacToe.models.Player;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Player player) throws InvalidMoveException {
        int size = board.getSize();
        Symbol symbol = player.getSymbol();

        boolean mainDiagonal = true;
        boolean antiDiagonal = true;

        for(int row = 0; row < size; row++) {
            if(board.getSymbol(row, row) != symbol) mainDiagonal = false;
            if(board.getSymbol(row, size - row  - 1) != symbol) antiDiagonal = false;

            if(!mainDiagonal && !antiDiagonal) break;
        }

        return mainDiagonal || antiDiagonal;
    }
}
