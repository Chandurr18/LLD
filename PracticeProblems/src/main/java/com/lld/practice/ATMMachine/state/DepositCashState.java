package com.lld.practice.ATMMachine.state;

import com.lld.practice.ATMMachine.enums.ATMStatus;
import com.lld.practice.ATMMachine.factory.ATMStateFactory;
import com.lld.practice.ATMMachine.model.Card;
import com.lld.practice.ATMMachine.service.ATMMachine;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DepositCashState implements ATMState{
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
        System.out.println("Cannot dispense in deposit State!!!");
    }

    @Override
    public void depositCash(int amount) {
        double curBalance = atmMachine.getCurrentCard().getAccount().getBalance();
        atmMachine.getCurrentCard().getAccount().setBalance(curBalance + amount);
        System.out.println("Deposited " + amount + ". Current balance: " + (curBalance + amount) + ".");
        ejectCard();
    }

    @Override
    public void enquiry() {
        System.out.println("Cannot enquiry in deposit State!!!");
    }

    @Override
    public void ejectCard() {
        atmMachine.setCurrentCard(null);
        System.out.println("Card Ejected...");
        atmMachine.setState(ATMStateFactory.getState(ATMStatus.IDLE, atmMachine));
    }

    @Override
    public ATMStatus getStatus() {
        return ATMStatus.DEPOSIT_CASH;
    }
}
