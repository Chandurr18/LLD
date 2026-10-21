package com.lld.practice.Chess.models;

import com.lld.practice.Chess.enums.Color;
import com.lld.practice.Chess.enums.PieceType;
import com.lld.practice.Chess.strategy.DiagonalMoveStrategy;
import com.lld.practice.Chess.strategy.HorizontalMoveStrategy;
import com.lld.practice.Chess.strategy.VerticalMoveStrategy;

public class Queen extends Piece{
    @Override
    public PieceType getPieceType() {
        return PieceType.QUEEN;
    }

    public Queen(Color color){
        super(color);
        strategies.add(new DiagonalMoveStrategy());
        strategies.add(new HorizontalMoveStrategy());
        strategies.add(new VerticalMoveStrategy());
    }
}
