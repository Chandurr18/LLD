package com.lld.practice.Chess.strategy;

import com.lld.practice.Chess.models.Action;
import com.lld.practice.Chess.models.Cell;
import com.lld.practice.Chess.models.Move;
import com.lld.practice.Chess.models.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LshapeMoveStrategy implements MoveStrategy{

    @Override
    public boolean isValidMove(Piece piece, Cell from, Cell to, Cell[][] board) {
        int rowDiff = Math.abs(from.getRow() - to.getRow());
        int colDiff = Math.abs(from.getCol() - to.getCol());

        if(!((rowDiff == 1 && colDiff == 2) || (rowDiff == 2 && colDiff == 1))) return false;

        Piece destPiece = to.getPiece();
        return destPiece == null || destPiece.getColor() != piece.getColor();
    }

    @Override
    public Optional<Move> move(Piece piece, Cell from, Cell to, Cell[][] board) {
        if(!isValidMove(piece, from, to, board)) return Optional.empty();

        List<Action> actions = new ArrayList<>();

        Piece destPiece = to.getPiece();
        from.setPiece(null);
        to.setPiece(piece);
        piece.incrementMoves();

        System.out.println(piece.getPieceType() + " moved from " + from + " to " + to);

        Action action = new Action(piece, from, to, destPiece, piece.getNumOfMoves());

        return Optional.of(new Move(List.of(action)));

    }
}
