package com.lld.practice.Chess.service;

import com.lld.practice.Chess.exception.CannotMoveToDestinationException;
import com.lld.practice.Chess.exception.CannotPerformRedoException;
import com.lld.practice.Chess.exception.CannotPerformUndoException;
import com.lld.practice.Chess.exception.NoPieceOnCellException;
import com.lld.practice.Chess.models.*;
import com.lld.practice.Chess.observer.GameBroadcaster;
import com.lld.practice.Chess.observer.Spectator;
import com.lld.practice.Chess.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class Game implements GameBroadcaster {
    private final Player whitePlayer;
    private final Player blackPlayer;
    private boolean isWhiteTurn;
    private final Scanner input;
    private final List<Spectator> spectators;

    private final Board board;
    private final MoveService moveService;


    public Game(Player whitePlayer, Player blackPlayer){
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        isWhiteTurn = true;
        input = new Scanner(System.in);
        spectators = new ArrayList<>();
        board = new Board();
        moveService = new MoveService(board);
    }


    @Override
    public void addSpectator(Spectator spectator) {
        spectators.add(spectator);
    }

    @Override
    public void removeSpectator(Spectator spectator) {
        spectators.remove(spectator);
    }

    @Override
    public void notifySpectator(String moveInfo) {
        for(Spectator spectator: spectators){
            spectator.update(moveInfo);
        }
    }

    public void start() {
        System.out.println();

        board.print();

        while(true) {
            System.out.println();

            Player currentPlayer = isWhiteTurn ? whitePlayer : blackPlayer;

            System.out.println(currentPlayer.getName() + "'s turn (" + (isWhiteTurn ? "WHITE" : "BLACK") + ")");
            String[] moveInput = currentPlayer.decideMove(board);
            String src = moveInput[0];
            String dest = moveInput[1];

            try {
                Optional<Move> move = moveService.makeMove(src, dest, currentPlayer.getColor());
                if(move.isEmpty()) continue;

                Move performedMove = move.get();

                Action mainAction = performedMove.getActions().get(0);

                String moveInfo = currentPlayer.getColor() + " " +
                        mainAction.getPiece().getPieceType() +
                        " moved from " + Utils.convertCellToString(mainAction.getFrom()) +
                        " to " + Utils.convertCellToString(mainAction.getTo());

                notifySpectator(moveInfo);

                System.out.println();
                board.print();

                if(currentPlayer instanceof HumanPlayer){
                    postMoveOptions();
                }

                isWhiteTurn = !isWhiteTurn;
            } catch (CannotMoveToDestinationException | NoPieceOnCellException | CannotPerformUndoException |
                     CannotPerformRedoException e) {
                System.out.println("❌ Invalid move. Try again.");
            }

            if(board.checkIfWon(currentPlayer.getColor())){
                board.print();
                System.out.println("🏆 " + currentPlayer.getName() + " won the game!");
                notifySpectator("🏆 " + currentPlayer.getName() + " won the game!");
                break;
            }
        }
    }

    private  void postMoveOptions() throws CannotPerformUndoException, CannotPerformRedoException {
        System.out.print("Options: (U)ndo | (R)edo | (C)ontinue: ");
        String choice = input.next().trim().toUpperCase();

        switch (choice){
            case "U" :
                if(moveService.canUndo()){
                    Move undone = moveService.undo();
                    Action mainAction = undone.getActions().get(0);

                    String undoMsg = "Undo: " +mainAction.getPiece().getPieceType() +
                            " moved back to " + Utils.convertCellToString(mainAction.getFrom());

                    notifySpectator(undoMsg);
                } else {
                    throw new CannotPerformUndoException("Undo cannot be performed!!!");
                }
                break;

            case "R" :
                if(moveService.canRedo()){
                    Move redone = moveService.redo();
                    Action mainAction = redone.getActions().get(0);

                    String redoMsg = "Redo: " + mainAction.getPiece().getPieceType() +
                            " moved again to " + Utils.convertCellToString(mainAction.getTo());

                    notifySpectator(redoMsg);
                } else {
                    throw new CannotPerformRedoException("Undo cannot be performed!!!");
                }
                break;

            case "C":
                return;

            default:
                System.out.println("Invalid option. Chooose U, R or C.");
        }
    }
}
