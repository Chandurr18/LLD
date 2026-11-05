package com.lld.practice.TicTacToe.strategy;

import com.lld.practice.TicTacToe.enums.Symbol;
import com.lld.practice.TicTacToe.exceptions.InvalidMoveException;
import com.lld.practice.TicTacToe.models.Board;
import com.lld.practice.TicTacToe.models.Player;

public class ColWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Player player) throws InvalidMoveException {
        int size = board.getSize();
        Symbol symbol = player.getSymbol();

        for(int col = 0; col < size; col++) {
            boolean colWin = true;

            for(int row = 0; row < size; row++) {
                if(board.getSymbol(row, col) != symbol) {
                    colWin = false;
                    break;
                }
            }

            if(colWin) return true;
        }

        return false;
    }
}
