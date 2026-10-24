package com.lld.practice.ATMMachine.ChainOfResponsibility;

import com.lld.practice.ATMMachine.model.ATM;

public class FiveHundredDispenser implements CashDispenser{
    private CashDispenser next;

    @Override
    public void setNextDispenser(CashDispenser next) {
        this.next = next;
    }

    @Override
    public boolean canDispense(ATM atm, int amount) {
        int count = atm.getTwoThousandCount();
        int notes = Math.min(amount / 500, count);
        int remainder = amount - notes * 500;
        return remainder == 0 || (next != null && next.canDispense(atm, remainder));
    }

    @Override
    public void dispense(ATM atm, int amount) {
        int count = atm.getFiveHundredCount();
        int notes = Math.min(amount / 500, count);
        atm.setFiveHundredCount(count - notes);

        int remainder = amount - notes * 500;
        if(notes > 0) System.out.println("Dispensed " + notes + " x 500/- notes");

        if(remainder > 0 && next != null) {
            next.dispense(atm, remainder);
        }
    }
}
