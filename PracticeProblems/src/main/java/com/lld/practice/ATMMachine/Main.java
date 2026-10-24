package com.lld.practice.ATMMachine;

import com.lld.practice.ATMMachine.enums.ATMStatus;
import com.lld.practice.ATMMachine.model.ATM;
import com.lld.practice.ATMMachine.model.Account;
import com.lld.practice.ATMMachine.model.Card;
import com.lld.practice.ATMMachine.repository.ATMRepository;
import com.lld.practice.ATMMachine.service.ATMMachine;

public class Main {
    public static void main(String[] args) {
        Card card = new Card(
                "CARD123",
                "1234",
                new Account("ACC123", 5000)
        );

        ATM atm1 = new ATM("ATM1", ATMStatus.IDLE, 4000, 1, 2, 10);
        ATM atm2 = new ATM("ATM2", ATMStatus.IDLE, 2000, 0, 3, 5);

        ATMRepository atmRepository = new ATMRepository();
        atmRepository.save(atm1);
        atmRepository.save(atm2);

        ATMMachine atmMachine1 = new ATMMachine("ATM1", atmRepository);

        atmMachine1.insertCard(card);
    }
}
