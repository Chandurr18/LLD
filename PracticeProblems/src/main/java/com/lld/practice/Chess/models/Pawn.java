package com.lld.practice.Chess.models;

import com.lld.practice.Chess.enums.Color;
import com.lld.practice.Chess.enums.PieceType;
import com.lld.practice.Chess.strategy.PawnMoveStrategy;
import com.lld.practice.Chess.strategy.PawnPromotionStrategy;

public class Pawn extends Piece{
    @Override
    public PieceType getPieceType() {
        return PieceType.PAWN;
    }

    public Pawn(Color color){
        super(color);
        strategies.add(new PawnMoveStrategy());
        strategies.add(new PawnPromotionStrategy());
    }
}
