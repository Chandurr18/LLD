package com.lld.practice.ATMMachine.model;

import com.lld.practice.ATMMachine.enums.ATMStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class ATM {
    private final String id;
    @Setter private ATMStatus status;
    @Setter private double cashAvailable;

    @Setter private int twoThousandCount;
    @Setter private int oneHundredCount;
    @Setter private int fiveHundredCount;
}
