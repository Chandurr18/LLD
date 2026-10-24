package com.lld.practice.ATMMachine.state;

import com.lld.practice.ATMMachine.enums.ATMStatus;
import com.lld.practice.ATMMachine.factory.ATMStateFactory;
import com.lld.practice.ATMMachine.model.Card;
import com.lld.practice.ATMMachine.service.ATMMachine;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CardInsertedState implements ATMState{
    private final ATMMachine atmMachine;

    @Override
    public void insertCard(Card card) {
        System.out.println("Card Already Inserted!!!");
    }

    @Override
    public void enterPin(String pin) {
        if(atmMachine.getCurrentCard().getPin().equals(pin)){
            System.out.println("Pin Correct. Authenticated.\n");
            atmMachine.setState(ATMStateFactory.getState(ATMStatus.AUTHENTICATED, atmMachine));
            atmMachine.selectOption();
        } else {
            System.out.println("Incorrect Pin. Please try again!!!\n");
            atmMachine.enterPin();
        }
    }

    @Override
    public void selectOption() {
        System.out.println("Enter Pin First!!!");
    }

    @Override
    public void dispenseCash(int amount) {
        System.out.println("Enter Pin First!!!");
    }

    @Override
    public void depositCash(int amount) {
        System.out.println("Enter Pin First!!!");
    }

    @Override
    public void enquiry() {
        System.out.println("Enter Pin First!!!");
    }

    @Override
    public void ejectCard() {
        atmMachine.setCurrentCard(null);
        System.out.println("Card Ejected...");
        atmMachine.setState(ATMStateFactory.getState(ATMStatus.IDLE, atmMachine));
    }

    @Override
    public ATMStatus getStatus() {
        return ATMStatus.CARD_INSERTED;
    }
}
