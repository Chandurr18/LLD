package com.lld.practice.TicTacToe.models;

import com.lld.practice.TicTacToe.enums.Symbol;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private final String playerId;
    private final String name;
    private final Symbol symbol;
}
