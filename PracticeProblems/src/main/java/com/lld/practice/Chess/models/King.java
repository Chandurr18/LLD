package com.lld.practice.Chess.models;

import com.lld.practice.Chess.enums.Color;
import com.lld.practice.Chess.enums.PieceType;
import com.lld.practice.Chess.strategy.CastlingMoveStrategy;
import com.lld.practice.Chess.strategy.KingMoveStrategy;

public class King extends Piece{
    @Override
    public PieceType getPieceType() {
        return PieceType.KING;
    }

    public King(Color color){
        super(color);
        strategies.add(new KingMoveStrategy());
        strategies.add(new CastlingMoveStrategy());
    }
}
