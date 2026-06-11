package controller;

import controller.dto.ExitResult;
import domain.entities.Ticket;
import service.PaymentService;
import service.PricingService;
import service.SlotService;
import service.TicketService;

public class ExitController {
    private TicketService ticketService;
    private PricingService pricingService;
    private PaymentService paymentService;
    private SlotService slotService;

    public ExitController(TicketService ticketService, PricingService pricingService, PaymentService paymentService, SlotService slotService) {
        this.ticketService = ticketService;
        this.pricingService = pricingService;
        this.paymentService = paymentService;
        this.slotService = slotService;
        System.out.println("[CONTROLLER] ExitController Initialted");
    }

    public ExitResult exitVehicle(String ticketId) {
        System.out.println("[CONTROLLER] vehicle exit request - ticketId: " + ticketId);

        Ticket ticket = ticketService.getTicketByID(ticketId);

        if (ticket == null) {
            return new ExitResult(false, ticketId, 0.0, "Invalid Ticket ID");
        }

        double fee = pricingService.calculateFee(ticket);

        boolean isPaymentSuccess = paymentService.processPayment(fee);
        if (!isPaymentSuccess) {
            return new ExitResult(false, ticketId, 0.0, "Payment Failed");
        }

        // Remove from active tickets
        ticketService.removeActiveTicket(ticketId);

        //release spot
        slotService.releaseSlot(ticket);

        System.out.println("[CONTROLLER] vehicile exit successfull - Ticket:" + ticketId + ", Fee: " + fee);

        return new ExitResult(false, ticketId, fee, "Exit successfull");
    }
}
