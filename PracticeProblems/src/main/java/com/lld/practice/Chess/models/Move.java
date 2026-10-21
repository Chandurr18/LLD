package com.lld.practice.Chess.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Move {
    private final List<Action> actions;
}
