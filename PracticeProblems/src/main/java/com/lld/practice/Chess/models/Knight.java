package com.lld.practice.Chess.models;

import com.lld.practice.Chess.enums.Color;
import com.lld.practice.Chess.enums.PieceType;
import com.lld.practice.Chess.strategy.LshapeMoveStrategy;

public class Knight extends Piece{
    @Override
    public PieceType getPieceType() {
        return PieceType.KNIGHT;
    }

    public Knight(Color color){
        super(color);
        strategies.add(new LshapeMoveStrategy());
    }
}
