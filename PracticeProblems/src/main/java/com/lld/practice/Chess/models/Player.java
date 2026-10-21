package com.lld.practice.Chess.models;

import com.lld.practice.Chess.enums.Color;
import com.lld.practice.Chess.enums.PlayerType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Player {
    protected String name;
    protected Color color;

    public abstract PlayerType getPlayerType();

    public abstract  String[] decideMove(Board board);
}
