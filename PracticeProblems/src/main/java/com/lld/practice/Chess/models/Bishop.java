package com.lld.practice.Chess.models;

import com.lld.practice.Chess.enums.Color;
import com.lld.practice.Chess.enums.PieceType;
import com.lld.practice.Chess.strategy.DiagonalMoveStrategy;

public class Bishop extends Piece{
    @Override
    public PieceType getPieceType() {
        return PieceType.BISHOP;
    }

    public Bishop(Color color){
        super(color);
        strategies.add(new DiagonalMoveStrategy());
    }
}
