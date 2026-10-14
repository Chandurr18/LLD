package com.lld.practice.BookMyShow.model;

import com.lld.practice.BookMyShow.enums.SeatType;

public class RegularSeat extends Seat{
    public RegularSeat(String id, double price){
        super(id, price);
    }

    public SeatType getType(){
        return SeatType.REGULAR;
    }
}
