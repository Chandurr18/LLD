package com.lld.practice.Chess.utils;

import com.lld.practice.Chess.enums.Color;
import com.lld.practice.Chess.models.Board;
import com.lld.practice.Chess.models.Cell;
import com.lld.practice.Chess.models.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Utils {
    private Utils() {}

    public static Cell convertStringToCell(String position, Cell[][] board) {
        if (position == null || !position.trim().matches("(?i)[a-h][1-8]")) {
            throw new IllegalArgumentException("Invalid square: " + position + ". Use a1 through h8.");
        }
        String value = position.trim().toLowerCase();
        int col = value.charAt(0) - 'a';
        int row = 8 - Character.getNumericValue(value.charAt(1));
        return board[row][col];
    }

    public static String convertCellToString(Cell cell) {
        return "" + (char) ('a' + cell.getCol()) + (8 - cell.getRow());
    }

    public static String[] generateRandomMove(Board board, Color color) {
        Cell[][] cells = board.getBoard();
        List<String[]> legalMoves = new ArrayList<>();

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Piece piece = cells[r][c].getPiece();
                if (piece == null || piece.getColor() != color) continue;

                for (int tr = 0; tr < 8; tr++) {
                    for (int tc = 0; tc < 8; tc++) {
                        if (r == tr && c == tc) continue;
                        if (piece.isValidMove(cells[r][c], cells[tr][tc], cells)) {
                            legalMoves.add(new String[] {
                                    convertCellToString(cells[r][c]),
                                    convertCellToString(cells[tr][tc])
                            });
                        }
                    }
                }
            }
        }

        if (legalMoves.isEmpty()) {
            // The game loop can detect that no move is available and end the game.
            throw new IllegalStateException("No legal moves available for " + color);
        }
        return legalMoves.get(new Random().nextInt(legalMoves.size()));
    }
}
