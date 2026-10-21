package com.lld.practice.Chess.observer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConsoleSpectator implements  Spectator{
    private final String name;
    @Override
    public void update(String moveInfo) {
        System.out.println("👀 " + name + " saw move: " + moveInfo);
    }
}
