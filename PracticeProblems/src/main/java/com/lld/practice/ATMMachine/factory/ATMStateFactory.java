package com.lld.practice.ATMMachine.factory;

import com.lld.practice.ATMMachine.enums.ATMStatus;
import com.lld.practice.ATMMachine.service.ATMMachine;
import com.lld.practice.ATMMachine.state.*;

public class ATMStateFactory {
    public static ATMState getState(ATMStatus atmStatus, ATMMachine atmMachine){
        return switch (atmStatus){
            case ENQUIRY_BALANCE -> new EnquiryState(atmMachine);
            case CARD_INSERTED-> new CardInsertedState(atmMachine);
            case AUTHENTICATED -> new AuthenticatedState(atmMachine);
            case DISPENSE_CASH -> new DispenseCashState(atmMachine);
            case DEPOSIT_CASH -> new DepositCashState(atmMachine);
            default -> new IdleState(atmMachine);
        };
    }
}
