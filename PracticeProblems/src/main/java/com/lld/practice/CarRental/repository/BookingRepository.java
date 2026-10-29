package com.lld.practice.CarRental.repository;

import com.lld.practice.CarRental.model.Booking;

import java.util.*;

public class BookingRepository {
    private final Map<String, Booking> bookings = new HashMap<>();

    public void addBooking(Booking booking) {
        bookings.put(booking.getBookingId(), booking);
    }

    public Optional<Booking> getBookingById(String bookingId) {
        return Optional.ofNullable(bookings.get(bookingId));
    }

    public void removeBooking(String bookingId) {
        bookings.remove(bookingId);
    }

    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings.values());
    }
}
