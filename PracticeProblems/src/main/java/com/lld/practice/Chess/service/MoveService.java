package com.lld.practice.Chess.service;

import com.lld.practice.Chess.enums.Color;
import com.lld.practice.Chess.exception.CannotMoveToDestinationException;
import com.lld.practice.Chess.exception.CannotPerformRedoException;
import com.lld.practice.Chess.exception.CannotPerformUndoException;
import com.lld.practice.Chess.exception.NoPieceOnCellException;
import com.lld.practice.Chess.models.*;
import com.lld.practice.Chess.utils.Utils;
import lombok.Getter;

import java.util.Optional;
import java.util.Stack;

public class MoveService {
    @Getter
    private final Stack<Move> movehistory = new Stack<>();

    @Getter
    private final Stack<Move> redoStack = new Stack<>();

    private final Board board;

    public MoveService(Board board){
        this.board = board;
    }

    public Optional<Move> makeMove(String srcStr, String destStr, Color currentPlayerColor) throws CannotMoveToDestinationException, NoPieceOnCellException {
        if(srcStr.equals(destStr)) {
            throw  new CannotMoveToDestinationException("Invalid move. Try again!!!");
        }

        Cell from = Utils.convertStringToCell(srcStr, board.getBoard());
        Cell to = Utils.convertStringToCell(destStr, board.getBoard());

        Piece selectedPiece = from.getPiece();

        if(selectedPiece == null) {
            throw new NoPieceOnCellException("There is no piece on " + srcStr);
        }

        if(selectedPiece.getColor() != currentPlayerColor) {
            throw  new CannotMoveToDestinationException("You cannot move opponent's piece.");
        }

        if(to.getPiece() != null &&  to.getPiece().getColor() == currentPlayerColor) {
            throw  new CannotMoveToDestinationException("Destination occupied by your own piece.");
        }

        Optional<Move> moveResult = selectedPiece.move(from, to, board.getBoard());

        if(moveResult.isEmpty()){
            throw new CannotMoveToDestinationException("Invalid Move. Try again. !!!");
        }

        movehistory.push(moveResult.get());
        redoStack.clear();

        return moveResult;
    }

    public boolean canUndo() { return !movehistory.isEmpty(); }

    public boolean canRedo() { return !redoStack.isEmpty(); }

    public Move undo() throws CannotPerformUndoException {
        if(!canUndo()) {
            throw new CannotPerformUndoException("Undo cannot be performed!!!");
        }

        Move lastMove = movehistory.pop();

        for(Action action: lastMove.getActions()){
            action.getFrom().setPiece(action.getPiece());
            action.getTo().setPiece(action.getCapturedPiece());
            action.getPiece().decrementMoves();
        }

        redoStack.push(lastMove);
        return lastMove;
    }

    public Move redo() throws  CannotPerformRedoException {
        if(!canUndo()) {
            throw new CannotPerformRedoException("Redo cannot be performed!!!");
        }

        Move move = redoStack.pop();

        for(Action action: move.getActions()){
            action.getFrom().setPiece(null);
            action.getTo().setPiece(action.getPiece());
            action.getPiece().incrementMoves();
        }

        movehistory.push(move);
        return move;
    }

}
