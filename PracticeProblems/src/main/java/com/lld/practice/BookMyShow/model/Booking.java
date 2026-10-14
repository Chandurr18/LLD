package com.lld.practice.BookMyShow.model;
import com.lld.practice.BookMyShow.enums.BookingStatus;
import com.lld.practice.BookMyShow.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Booking {
    private final String bookingId;
    private final String userId;
    private final List<String> seatIds;
    private final double amount;
    @Setter
    private BookingStatus status;
    @Setter
    private PaymentType paymentType;
    private final String showId;

}
