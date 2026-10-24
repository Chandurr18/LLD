package com.lld.practice.ATMMachine.state;

import com.lld.practice.ATMMachine.ChainOfResponsibility.CashDispenser;
import com.lld.practice.ATMMachine.ChainOfResponsibility.CashDispenserChainBuilder;
import com.lld.practice.ATMMachine.enums.ATMStatus;
import com.lld.practice.ATMMachine.factory.ATMStateFactory;
import com.lld.practice.ATMMachine.model.Card;
import com.lld.practice.ATMMachine.service.ATMMachine;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DispenseCashState implements ATMState{
    private final ATMMachine atmMachine;
    CashDispenser chain = CashDispenserChainBuilder.buildChain();

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
        double atmBalance = atmMachine.getAtm().getCashAvailable();
        double accountBalance = atmMachine.getCurrentCard().getAccount().getBalance();

        if(amount > atmBalance) {
            System.out.println("ATM has insufficient cash, Cannot dispense " + amount);
            ejectCard();
            return;
        }

        if(amount > accountBalance) {
            System.out.println("Insufficient account balance.");
            ejectCard();
            return;
        }

        if(chain.canDispense(atmMachine.getAtm(), amount)) {
            chain.dispense(atmMachine.getAtm(), amount);

            // deduct from ATM cash & account balance
            atmMachine.getAtm().setCashAvailable(atmBalance - amount);
            atmMachine.getCurrentCard().getAccount().setBalance(accountBalance - amount);

            System.out.println("Cash dispensed: " + amount + ". Available Balance: " + atmMachine.getCurrentCard().getAccount().getBalance());
        } else {
            System.out.println("Cannot dispense requested amount with available cash");
        }
        ejectCard();
    }

    @Override
    public void depositCash(int amount) {
        System.out.println("Cannot deposit in Dispense Option!!!");
    }

    @Override
    public void enquiry() {
        System.out.println("Cannot enquiry in Deposit Option!!!");
    }

    @Override
    public void ejectCard() {
        atmMachine.setCurrentCard(null);
        System.out.println("Card Ejected...");
        atmMachine.setState(ATMStateFactory.getState(ATMStatus.IDLE, atmMachine));
    }

    @Override
    public ATMStatus getStatus() {
        return ATMStatus.DISPENSE_CASH;
    }
}
