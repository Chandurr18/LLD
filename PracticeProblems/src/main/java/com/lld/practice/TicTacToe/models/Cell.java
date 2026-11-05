package com.lld.practice.TicTacToe.models;

import com.lld.practice.TicTacToe.enums.Symbol;
import com.lld.practice.TicTacToe.exceptions.InvalidMoveException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
public class Cell {
    private final int row;
    private final int col;
    private Symbol symbol = Symbol.EMPTY;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean isEmpty() {
        return symbol == Symbol.EMPTY;
    }

    public void setSymbol(Symbol symbol) throws InvalidMoveException {
        if(!isEmpty()) {
            throw new InvalidMoveException("Cell is already occupied");
        }

        this.symbol = symbol;
    }
}
