package repository;


import model.Booking;

import java.util.HashMap;
import java.util.Map;


public class BookingRepository {
    private final Map<String, Booking> bookings = new HashMap<>();

    public void save(Booking booking){
        bookings.put(booking.getBookingId(), booking);
    }

    public Booking get(String id){
        return bookings.get(id);
    }
}
