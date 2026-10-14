package com.lld.practice.SnakeAndLadders.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Player {
    private final String name;
    private int position = 1;
}
