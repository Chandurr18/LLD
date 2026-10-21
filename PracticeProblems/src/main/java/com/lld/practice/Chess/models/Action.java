package com.lld.practice.Chess.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Action {
    private final Piece piece;
    private final Cell from;
    private final Cell to;
    private final Piece capturedPiece;
    private final int moveNumber;
}
