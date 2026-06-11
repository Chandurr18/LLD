package service;

import java.util.concurrent.atomic.AtomicInteger;

import domain.entities.ParkingSpot;
import domain.entities.Ticket;
import domain.entities.Vehicle;
import repository.TicketRepository;

public class TicketService {
    /*
     * For a single-machine implementation use AtomicInteger for simplicity.
     * In a distributed system, replace it with UUID or a distributed ID
     * generator like Snowflake to avoid ID collisions.
     */

    private final AtomicInteger tid = new AtomicInteger(101);
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot spot) {
        String ticketId = "T-" + tid.getAndIncrement();
        Ticket ticket = new Ticket(ticketId, vehicle, spot);

        ticketRepository.save(ticket);

        return ticket;
    }

    public Ticket getTicketByID(String ticketId) {
        Ticket ticket = ticketRepository.getTicketByID(ticketId);

        return ticket;
    }

    public synchronized void removeActiveTicket(String ticketId) {
        ticketRepository.removeTicket(ticketId);
    }
}
