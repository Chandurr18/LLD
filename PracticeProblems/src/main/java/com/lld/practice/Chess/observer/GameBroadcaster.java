package com.lld.practice.Chess.observer;

public interface GameBroadcaster {
    void addSpectator(Spectator spectator);
    void removeSpectator(Spectator spectator);
    void notifySpectator(String moveInfo);
}
