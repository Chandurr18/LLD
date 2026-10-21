package com.lld.practice.Chess.strategy;

import com.lld.practice.Chess.enums.Color;
import com.lld.practice.Chess.enums.PieceType;
import com.lld.practice.Chess.models.Action;
import com.lld.practice.Chess.models.Cell;
import com.lld.practice.Chess.models.Move;
import com.lld.practice.Chess.models.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CastlingMoveStrategy implements  MoveStrategy{
    @Override
    public boolean isValidMove(Piece piece, Cell from, Cell to, Cell[][] board) {
        Color color = piece.getColor();

        int row = from.getRow();
        int colDiff = Math.abs(to.getCol() - from.getCol());

        if(piece.getNumOfMoves() != 0 || colDiff != 2) return false;

        boolean kingSide = to.getCol() > from.getCol();
        int rookCol = kingSide ? 7 : 0;

        Cell rookCell = board[row][rookCol];
        Piece rook = rookCell.getPiece();

        if (rook == null ||
                rook.getPieceType() != PieceType.ROOK ||
                rook.getColor() != color ||
                rook.getNumOfMoves() != 0
        ) {
            return false;
        }

        int step = kingSide ? 1 : -1;
        for(int c = from.getCol() + step; c != rookCol; c += step) {
            if(board[row][c].getPiece() != null) return false;
        }

        return true;
    }

    @Override
    public Optional<Move> move(Piece king, Cell from, Cell to, Cell[][] board) {
        if(!isValidMove(king, from, to, board)) return Optional.empty();

        int row = to.getRow();

        boolean kingSide = to.getCol() > from.getCol();
        int rookCol = kingSide ? 7 : 0;

        int rookDestCol = kingSide ? to.getCol() - 1 : to.getCol() + 1;

        Cell rookSrc = board[row][rookCol];
        Cell rookDest = board[row][rookDestCol];
        Piece rook = rookSrc.getPiece();

        List<Action> actions = new ArrayList<>();

        from.setPiece(null);
        to.setPiece(king);
        king.incrementMoves();
        actions.add(new Action(king, from, to, null, king.getNumOfMoves()));

        rookSrc.setPiece(null);
        rookDest.setPiece(rook);
        rook.incrementMoves();
        actions.add(new Action(rook, rookSrc, rookDest, null, rook.getNumOfMoves()));

        return Optional.of(new Move(actions));
    }
}
