package com.lld.practice.CarRental.model;

import com.lld.practice.CarRental.enums.BookingStatus;
import com.lld.practice.CarRental.enums.PaymentStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
public class Booking {
    private String bookingId;
    private User user;
    private Vehicle vehicle;
    private Branch pickupBranch;
    private Branch dropBranch;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BookingStatus status = BookingStatus.CREATED;
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
    private double amount;

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM h:mm a yyyy");

        return "\n" +
                "Booking ID: " + bookingId + "\n" +
                "User: " + (user != null ? user.getName() : "N/A") + "\n" +
                "Pickup Time: " + (startTime != null ? startTime.format(formatter) : "N/A") + "\n" +
                "Drop Time: " + (endTime != null ? endTime.format(formatter) : "N/A") + "\n" +
                "Pickup Location: " + (pickupBranch != null ? pickupBranch.getCity() : "N/A") + "\n" +
                "Drop Location: " + (dropBranch != null ? dropBranch.getCity() : "N/A") + "\n" +
                "Vehicle Type: " + (vehicle != null ? vehicle.getType() : "N/A") + "\n" +
                "Vehicle Number Plate: " + (vehicle != null ? vehicle.getLicensePlate() : "N/A") + "\n" +
                "Amount: $" + String.format("%.2f", amount) + "\n" +
                "Status: " + status + "\n" +
                "Payment Status: " + paymentStatus + "\n";
    }
}
