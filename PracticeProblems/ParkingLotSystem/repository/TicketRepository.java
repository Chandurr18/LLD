package repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import domain.entities.Ticket;

public class TicketRepository {
    private final Map<String, Ticket> activeTickets = new ConcurrentHashMap<>();

    public void save(Ticket ticket){
        activeTickets.put(ticket.getTicketId(), ticket);
    }

    public Ticket getTicketByID(String ticketId){
        if(ticketId == null) return null;
        return activeTickets.get(ticketId);
    }

    public void removeTicket(String ticketId){
        activeTickets.remove(ticketId);
    }
}
