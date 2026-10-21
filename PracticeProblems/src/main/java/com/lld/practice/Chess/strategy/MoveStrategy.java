package com.lld.practice.Chess.strategy;

import com.lld.practice.Chess.models.Cell;
import com.lld.practice.Chess.models.Move;
import com.lld.practice.Chess.models.Piece;

import java.util.Optional;

public interface MoveStrategy {
    boolean isValidMove(Piece piece, Cell from, Cell to, Cell[][] board);
    Optional<Move> move(Piece piece, Cell from, Cell to, Cell[][] board);
}
