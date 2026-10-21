package com.lld.practice.Chess.strategy;

import com.lld.practice.Chess.enums.Color;
import com.lld.practice.Chess.models.Action;
import com.lld.practice.Chess.models.Cell;
import com.lld.practice.Chess.models.Move;
import com.lld.practice.Chess.models.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PawnMoveStrategy implements MoveStrategy {
    @Override
    public boolean isValidMove(Piece piece, Cell from, Cell to, Cell[][] board) {
        int srcRow = from.getRow(), srcCol = from.getCol();
        int destRow = to.getRow(), destCol = to.getCol();

        int rowDiff = destRow - srcRow;
        int colDiff = Math.abs(destCol - srcCol);

        // Pawn must actually move
        if (rowDiff == 0 && colDiff == 0) return false;

        // White moves upward; black moves downward
        int direction = piece.getColor() == Color.WHITE ? -1 : 1;

        Piece captured = to.getPiece();

        // Forward movement: same column, destination must be empty
        if (colDiff == 0) {
            if (captured != null) return false;

            // Move one square forward
            if (rowDiff == direction) return true;

            // Move two squares forward on the first move only
            if (rowDiff == 2 * direction && piece.getNumOfMoves() == 0) {
                int intermediateRow = srcRow + direction;

                return board[intermediateRow][srcCol].getPiece() == null;
            }

            return false;
        }

        // Diagonal capture: one row forward and one column sideways
        if (colDiff == 1 && rowDiff == direction) {
            return captured != null && captured.getColor() != piece.getColor();
        }

        return false;
    }

    @Override
    public Optional<Move> move(Piece piece, Cell from, Cell to, Cell[][] board) {
        if (!isValidMove(piece, from, to, board)) { return Optional.empty(); }

        List<Action> actions = new ArrayList<>();

        Piece captured = to.getPiece();

        from.setPiece(null);
        to.setPiece(piece);
        piece.incrementMoves();

        actions.add(new Action(piece, from, to, captured, piece.getNumOfMoves()));

        System.out.println(piece.getPieceType() + " moved from " + from + " to " + to);

        return Optional.of(new Move(actions));
    }
}