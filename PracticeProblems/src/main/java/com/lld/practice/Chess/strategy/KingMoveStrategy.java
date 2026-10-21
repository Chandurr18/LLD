package com.lld.practice.Chess.strategy;

import com.lld.practice.Chess.enums.Color;
import com.lld.practice.Chess.enums.PieceType;
import com.lld.practice.Chess.factory.PieceFactory;
import com.lld.practice.Chess.models.Action;
import com.lld.practice.Chess.models.Cell;
import com.lld.practice.Chess.models.Move;
import com.lld.practice.Chess.models.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class KingMoveStrategy implements  MoveStrategy{
    @Override
    public boolean isValidMove(Piece piece, Cell from, Cell to, Cell[][] board) {
        int srcRow = from.getRow(), srcCol = from.getCol();
        int destRow = to.getRow(), destCol = to.getCol();

        int colDiff = Math.abs(srcCol - destCol);
        int rowDiff = Math.abs(srcRow - destCol);

        if(colDiff > 1 || rowDiff > 1) return false;

        Piece captured = to.getPiece();

        return captured == null || captured.getColor() != piece.getColor();
    }

    @Override
    public Optional<Move> move(Piece piece, Cell from, Cell to, Cell[][] board) {
        if(!isValidMove(piece, from, to, board)) return Optional.empty();

        Piece captured = to.getPiece();

        from.setPiece(null);
        to.setPiece(piece);
        piece.incrementMoves();

        List<Action> actions = new ArrayList<>();
        actions.add(new Action(piece, from, to, captured, piece.getNumOfMoves()));

        return Optional.of(new Move(actions));
    }
}
