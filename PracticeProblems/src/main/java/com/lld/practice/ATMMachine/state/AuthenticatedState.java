package com.lld.practice.ATMMachine.state;

import com.lld.practice.ATMMachine.enums.ATMStatus;
import com.lld.practice.ATMMachine.factory.ATMStateFactory;
import com.lld.practice.ATMMachine.model.Card;
import com.lld.practice.ATMMachine.service.ATMMachine;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class AuthenticatedState implements ATMState{
    private final ATMMachine atmMachine;
    private final Scanner input = new Scanner(System.in);

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
        while(true){
            System.out.print("Select Option: (E)nquiry Balance, (D)eposit Cash, (W)ithdraw Cash, (X)eject card: ");
            String option = input.next().toUpperCase();

             switch(option) {
                 case "W" -> {
                     System.out.println("\nOption Selected: Withdrawal.");
                     atmMachine.setState(ATMStateFactory.getState(ATMStatus.DISPENSE_CASH, atmMachine));
                     atmMachine.dispenseCash();
                     return;
                 }

                 case "E" -> {
                     System.out.println("\nOption Selected: Balance Enquiry.");
                     atmMachine.setState(ATMStateFactory.getState(ATMStatus.ENQUIRY_BALANCE, atmMachine));
                     atmMachine.enquiry();
                     return;
                 }

                 case "D" -> {
                     System.out.println("\nOption Selected: Deposit amount.");
                     atmMachine.setState(ATMStateFactory.getState(ATMStatus.DEPOSIT_CASH, atmMachine));
                     atmMachine.deposit();
                     return;
                 }

                 case "X" -> {
                     System.out.println("\nOption Selected: Eject Card.");
                     ejectCard();
                     return;
                 }

                 default -> {
                     System.out.println("Invalid Option Selected. Try again!!!\n");
                 }
             }
        }
    }

    @Override
    public void dispenseCash(int amount) {
        System.out.println("Select option first!!!");
    }

    @Override
    public void depositCash(int amount) {
        System.out.println("Select option first!!!");
    }

    @Override
    public void enquiry() {
        System.out.println("Select option first!!!");
    }

    @Override
    public void ejectCard() {
        atmMachine.setCurrentCard(null);
        System.out.println("Card Ejected...");
        atmMachine.setState(ATMStateFactory.getState(ATMStatus.IDLE, atmMachine));
    }

    @Override
    public ATMStatus getStatus() {
        return ATMStatus.AUTHENTICATED;
    }
}
