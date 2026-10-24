package com.lld.practice.ATMMachine.service;

import com.lld.practice.ATMMachine.factory.ATMStateFactory;
import com.lld.practice.ATMMachine.model.ATM;
import com.lld.practice.ATMMachine.model.Card;
import com.lld.practice.ATMMachine.repository.ATMRepository;
import com.lld.practice.ATMMachine.state.ATMState;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
public class ATMMachine {
    private final ATM atm;
    private ATMState state;
    private final ATMRepository atmRepository;
    @Setter private Card currentCard;
    Scanner input = new Scanner(System.in);

    public ATMMachine(String atmId, ATMRepository atmRepository){
        this.atmRepository = atmRepository;
        this.atm = atmRepository.getById(atmId)
                .orElseThrow(() -> new RuntimeException("ATM not found"));
        this.state = ATMStateFactory.getState(atm.getStatus(), this);
    }

    public void insertCard(Card card) {
        state.insertCard(card);

    }

    public void enterPin() {
        System.out.print("Enter Pin: ");
        String pin = input.next();
        state.enterPin(pin);
    }

    public void selectOption(){
        state.selectOption();
    }

    public void dispenseCash(){
        System.out.print("Enter Amount to deposit: ");
        int amount = input.nextInt();
        state.dispenseCash(amount);
    }

    public void ejectCard() {
        state.ejectCard();
    }

    public void enquiry() { state.enquiry(); }

    public void deposit() {
        System.out.print("Enter Amount to deposit: ");
        int amount = input.nextInt();
        state.depositCash(amount);
    }

    public void setState(ATMState state){
        this.state = state;
    }
}
