package com.lld.practice.ATMMachine.state;

import com.lld.practice.ATMMachine.enums.ATMStatus;
import com.lld.practice.ATMMachine.factory.ATMStateFactory;
import com.lld.practice.ATMMachine.model.Card;
import com.lld.practice.ATMMachine.service.ATMMachine;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EnquiryState implements ATMState{
    private final ATMMachine atmMachine;

    @Override
    public void insertCard(Card card) {
        System.out.println("Card Already Inserted!!!");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Pin Already Entered!!!");
    }

    @Override
    public void selectOption() {
        System.out.println("Option Already Selected!!!");
    }

    @Override
    public void dispenseCash(int amount) {
        System.out.println("Cannot dispense in Enquiry State!!!");
    }

    @Override
    public void depositCash(int amount) {
        System.out.println("Cannot deposit in Enquiry State!!!");
    }

    @Override
    public void enquiry() {
        System.out.println("Available Balance:" + atmMachine.getCurrentCard().getAccount().getBalance());
        ejectCard();
    }

    @Override
    public void ejectCard() {
        atmMachine.setCurrentCard(null);
        System.out.println("Card Ejected...");
        atmMachine.setState(ATMStateFactory.getState(ATMStatus.IDLE, atmMachine));
    }

    @Override
    public ATMStatus getStatus() {
        return ATMStatus.ENQUIRY_BALANCE;
    }
}
