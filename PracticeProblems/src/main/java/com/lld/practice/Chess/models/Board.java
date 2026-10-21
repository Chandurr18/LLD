package com.lld.practice.Chess.models;

import com.lld.practice.Chess.enums.Color;
import com.lld.practice.Chess.enums.PieceType;
import com.lld.practice.Chess.factory.PieceFactory;

public class Board {
    private final Cell[][] board = new Cell[8][8];

    public Board() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = new Cell(row, col, null);
            }
        }
        initializePieces();
    }

    public Cell[][] getBoard() {
        return board;
    }

    private void initializePieces() {
        PieceType[] backRank = {
                PieceType.ROOK, PieceType.KNIGHT, PieceType.BISHOP, PieceType.QUEEN,
                PieceType.KING, PieceType.BISHOP, PieceType.KNIGHT, PieceType.ROOK
        };

        for (int col = 0; col < 8; col++) {
            board[0][col].setPiece(PieceFactory.createPiece(backRank[col], Color.BLACK));
            board[1][col].setPiece(PieceFactory.createPiece(PieceType.PAWN, Color.BLACK));
            board[6][col].setPiece(PieceFactory.createPiece(PieceType.PAWN, Color.WHITE));
            board[7][col].setPiece(PieceFactory.createPiece(backRank[col], Color.WHITE));
        }
    }

    public void print() {
        // Column labels at the top
        System.out.println("   a    b    c    d    e    f    g    h");

        for (int row = 0; row < 8; row++) {

            // Row number on the left
            System.out.print((8 - row) + "  ");

            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col].getPiece();

                if (piece == null) {
                    System.out.printf("%-5s", "--");
                } else {
                    String symbol = getPieceSymbol(piece);
                    System.out.printf("%-5s", symbol);
                }
            }

            // Row number on the right
            System.out.println(" " + (8 - row));
        }

        // Column labels at the bottom
        System.out.println("   a    b    c    d    e    f    g    h");
    }

    private String getPieceSymbol(Piece piece) {
        String symbol = switch (piece.getPieceType()) {
            case KING -> "K";
            case QUEEN -> "Q";
            case ROOK -> "R";
            case BISHOP -> "B";
            case KNIGHT -> "N";
            case PAWN -> "P";
        };

        // Uppercase for white, lowercase for black
        return piece.getColor() == Color.WHITE
                ? "W" + symbol
                : "B" + symbol;
    }

    // Returns true when the opponent's king has been captured.
    public boolean checkIfWon(Color color) {
        Color opponent = color == Color.WHITE ? Color.BLACK : Color.WHITE;
        for (Cell[] row : board) {
            for (Cell cell : row) {
                Piece piece = cell.getPiece();
                if (piece != null && piece.getColor() == opponent
                        && piece.getPieceType() == PieceType.KING) {
                    return false;
                }
            }
        }
        return true;
    }
}
