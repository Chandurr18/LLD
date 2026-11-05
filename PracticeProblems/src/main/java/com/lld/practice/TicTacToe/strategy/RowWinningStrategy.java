package com.lld.practice.TicTacToe.strategy;

import com.lld.practice.TicTacToe.enums.Symbol;
import com.lld.practice.TicTacToe.exceptions.InvalidMoveException;
import com.lld.practice.TicTacToe.models.Board;
import com.lld.practice.TicTacToe.models.Player;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Player player) throws InvalidMoveException {
        int size = board.getSize();
        Symbol symbol = player.getSymbol();

        for(int row = 0; row < size; row++) {
            boolean rowWin = true;

            for(int col = 0; col < size; col++) {
                if(board.getSymbol(row, col) != symbol) {
                    rowWin = false;
                    break;
                }
            }

            if(rowWin) return true;
        }

        return false;
    }
}
