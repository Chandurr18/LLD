package com.lld.practice.Chess.factory;

import com.lld.practice.Chess.enums.Color;
import com.lld.practice.Chess.enums.PieceType;
import com.lld.practice.Chess.models.*;


public class PieceFactory {
    public static Piece createPiece(PieceType pieceType, Color color){
        return switch (pieceType){
            case KING -> new King(color);
            case ROOK -> new Rook(color);
            case QUEEN -> new Queen(color);
            case BISHOP -> new Bishop(color);
            case KNIGHT -> new Knight(color);
            case PAWN -> new Pawn(color);
        };
    }
}
