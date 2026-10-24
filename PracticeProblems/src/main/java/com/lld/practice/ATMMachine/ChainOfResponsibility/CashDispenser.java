package com.lld.practice.ATMMachine.ChainOfResponsibility;

import com.lld.practice.ATMMachine.model.ATM;

public interface CashDispenser {
    void setNextDispenser(CashDispenser next);
    boolean canDispense(ATM atm, int amount);
    void dispense(ATM atm, int amount);
}
