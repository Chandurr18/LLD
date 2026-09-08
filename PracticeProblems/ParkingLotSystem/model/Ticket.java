package model;

import java.time.LocalDateTime;

import enums.PaymentStatus;

public class Ticket {

    private String ticketId;
    private LocalDateTime entryTime;
    private Vehicle vehicle;
    private String floorId;
    private String spotId;
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    public Ticket() {
    }

    public Ticket(String ticketId,
                  LocalDateTime entryTime,
                  Vehicle vehicle,
                  String floorId,
                  String spotId) {

        this.ticketId = ticketId;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.floorId = floorId;
        this.spotId = spotId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", entryTime=" + entryTime +
                ", vehicle=" + vehicle +
                ", floorId='" + floorId + '\'' +
                ", spotId='" + spotId + '\'' +
                ", paymentStatus=" + paymentStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;

        Ticket ticket = (Ticket) o;

        return java.util.Objects.equals(ticketId, ticket.ticketId)
                && java.util.Objects.equals(entryTime, ticket.entryTime)
                && java.util.Objects.equals(vehicle, ticket.vehicle)
                && java.util.Objects.equals(floorId, ticket.floorId)
                && java.util.Objects.equals(spotId, ticket.spotId)
                && paymentStatus == ticket.paymentStatus;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(
                ticketId,
                entryTime,
                vehicle,
                floorId,
                spotId,
                paymentStatus
        );
    }
}

