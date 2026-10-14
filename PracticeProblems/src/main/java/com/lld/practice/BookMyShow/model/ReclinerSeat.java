package com.lld.practice.BookMyShow.model;

import com.lld.practice.BookMyShow.enums.SeatType;

public class ReclinerSeat extends Seat{
    public ReclinerSeat(String id, double amount){
        super(id, amount);
    }

    public SeatType getType(){
        return SeatType.RECLINER;
    }
}
