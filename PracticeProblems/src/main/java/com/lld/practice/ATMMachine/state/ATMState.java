package com.lld.practice.ATMMachine.state;

import com.lld.practice.ATMMachine.enums.ATMStatus;
import com.lld.practice.ATMMachine.model.Card;

public interface ATMState {
    void insertCard(Card card);
    void enterPin(String pin);
    void selectOption();
    void dispenseCash(int amount);
    void depositCash(int amount);
    void enquiry();
    void ejectCard();
    ATMStatus getStatus();
}
