package com.lld.practice.Chess.models;

import com.lld.practice.Chess.enums.Color;
import com.lld.practice.Chess.enums.PieceType;
import com.lld.practice.Chess.strategy.MoveStrategy;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public abstract class Piece {
    protected int numOfMoves = 0;
    protected final Color color;
    protected final List<MoveStrategy> strategies = new ArrayList<>();

    public Piece(Color color){ this.color = color; }

    public void incrementMoves(){ numOfMoves++; }

    public void decrementMoves(){ numOfMoves--; }

    public abstract PieceType getPieceType();

    public boolean isValidMove(Cell from, Cell to, Cell[][] board) {
        for(MoveStrategy strategy: strategies) {
            if(strategy.isValidMove(this, from, to, board)) return true;
        }
        
        return false;
    }

    public Optional<Move> move(Cell from, Cell to, Cell[][] board){
        for(MoveStrategy strategy: strategies){
            Optional<Move> move = strategy.move(this, from, to, board);

            if(move.isPresent()) return move;
        }

        return Optional.empty();
    }
}
