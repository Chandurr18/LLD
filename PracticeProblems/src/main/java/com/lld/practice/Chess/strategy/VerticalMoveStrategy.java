package com.lld.practice.Chess.strategy;

import com.lld.practice.Chess.models.Action;
import com.lld.practice.Chess.models.Cell;
import com.lld.practice.Chess.models.Move;
import com.lld.practice.Chess.models.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VerticalMoveStrategy implements  MoveStrategy{
    @Override
    public boolean isValidMove(Piece piece, Cell from, Cell to, Cell[][] board) {
        int srcRow = from.getRow(), srcCol = from.getCol();
        int destRow = to.getRow(), destCol = to.getCol();

        if ((srcCol != destCol) || (srcRow == destRow)) return false;

        int rowDir = Integer.signum(destRow - srcRow);

        int i = srcRow + rowDir, j = srcCol;

        while(i != destRow){
            if(board[i][j].getPiece() != null) return false;

            i += rowDir;
        }

        Piece destPiece = to.getPiece();

        return destPiece == null || destPiece.getColor() != piece.getColor();
    }

    @Override
    public Optional<Move> move(Piece piece, Cell from, Cell to, Cell[][] board) {
        if(!isValidMove(piece, from, to, board)) return  Optional.empty();

        List<Action> actions = new ArrayList<>();

        Piece destPiece = to.getPiece();

        from.setPiece(null);
        to.setPiece(piece);
        piece.incrementMoves();

        actions.add(new Action(piece, from, to, destPiece, piece.getNumOfMoves()));

        System.out.println(piece.getPieceType() + " moved from " + from + " to " + to);
        return Optional.of(new Move(actions));
    }
}
