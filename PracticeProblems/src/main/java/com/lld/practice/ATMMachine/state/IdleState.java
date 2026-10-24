package com.lld.practice.ATMMachine.state;

import com.lld.practice.ATMMachine.enums.ATMStatus;
import com.lld.practice.ATMMachine.factory.ATMStateFactory;
import com.lld.practice.ATMMachine.model.Card;
import com.lld.practice.ATMMachine.service.ATMMachine;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IdleState implements ATMState{
    private final ATMMachine atmMachine;

    @Override
    public void insertCard(Card card) {
        atmMachine.setCurrentCard(card);
        System.out.println("Card Inserted.\n");
        atmMachine.setState(ATMStateFactory.getState(ATMStatus.CARD_INSERTED, atmMachine));
        atmMachine.enterPin();
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("No Card Inserted!!!");
    }

    @Override
    public void selectOption() {
        System.out.println("No Card Inserted!!!");
    }

    @Override
    public void dispenseCash(int amount) {
        System.out.println("No Card Inserted!!!");
    }

    @Override
    public void depositCash(int amount) {
        System.out.println("No Card Inserted!!!");
    }

    @Override
    public void enquiry() {
        System.out.println("No Card Inserted!!!");
    }

    @Override
    public void ejectCard() {
        System.out.println("No Card Inserted!!!");
    }

    @Override
    public ATMStatus getStatus() {
        return ATMStatus.IDLE;
    }
}
