package com.lld.practice.VendingMachine.enums;

import lombok.Getter;

public enum Coin {
    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);

    @Getter
    private final int value;
    Coin(int value) {
        this.value = value;
    }
}
