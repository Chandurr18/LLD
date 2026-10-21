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

public class PawnPromotionStrategy implements MoveStrategy {

    @Override
    public boolean isValidMove(Piece piece, Cell from, Cell to, Cell[][] board) {
        int rowDiff = Math.abs(from.getRow() - to.getRow());
        int colDiff = Math.abs(from.getCol() - to.getCol());

        Piece destPiece = to.getPiece();

        // Pawn must move exactly one row to promote.
        if (rowDiff != 1) {
            return false;
        }

        // Promotion must happen on the final rank.
        boolean promotionRow =
                (piece.getColor() == Color.WHITE && to.getRow() == 0)
                        || (piece.getColor() == Color.BLACK && to.getRow() == 7);

        if (!promotionRow) {
            return false;
        }

        // Straight move: destination must be empty.
        if (colDiff == 0) {
            return destPiece == null;
        }

        // Diagonal capture: destination must contain an opponent's piece.
        if (colDiff == 1) {
            return destPiece != null
                    && destPiece.getColor() != piece.getColor();
        }

        return false;
    }

    @Override
    public Optional<Move> move(Piece piece, Cell from, Cell to, Cell[][] board) {
        if(!isValidMove(piece, from, to, board)) return Optional.empty();

        Color color = piece.getColor();

        Scanner sc = new Scanner(System.in);
        System.out.print("Promote to (QUEEN, ROOK, BISHOP, KNIGHT): ");
        String input = sc.nextLine().trim().toUpperCase();

        Piece promoted = PieceFactory.createPiece(PieceType.valueOf(input), color);
        Piece captured = to.getPiece();

        from.setPiece(null);
        to.setPiece(promoted);
        piece.incrementMoves();

        List<Action> actions = new ArrayList<>();
        actions.add(new Action(piece, from, to, captured, piece.getNumOfMoves()));

        return Optional.of(new Move(actions));
    }
}
