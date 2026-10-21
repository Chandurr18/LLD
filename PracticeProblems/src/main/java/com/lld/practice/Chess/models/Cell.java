package com.lld.practice.Chess.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Cell {
    private final int row;
    private final int col;

    @Setter
    private Piece piece = null;

    @Override
    public String toString() {
        char column = (char) ('a' + this.col);
        int rowNumber = 8 - this.row;

        return "" + column + rowNumber;
    }
}
