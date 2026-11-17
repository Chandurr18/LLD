package com.lld.practice.VendingMachine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Item {
    private final String name;
    private final String code;
    private final int price;
}
