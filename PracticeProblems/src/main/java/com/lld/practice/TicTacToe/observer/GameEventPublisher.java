package com.lld.practice.TicTacToe.observer;

import com.lld.practice.TicTacToe.models.Game;

import java.util.ArrayList;
import java.util.List;

public class GameEventPublisher {
    private final List<GameObserver> observers;

    public GameEventPublisher() {
        this.observers = new ArrayList<>();
    }

    public void subscribe(GameObserver observer) {
        this.observers.add(observer);
    }

    public void unSubscribe(GameObserver observer) {
        this.observers.remove(observer);
    }

    public void notifyAllSubscribers(Game game) {
        for(GameObserver observer : observers) {
            observer.update(game);
        }
    }
}
