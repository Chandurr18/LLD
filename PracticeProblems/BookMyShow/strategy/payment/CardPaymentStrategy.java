package strategy.payment;

import model.Booking;

public class CardPaymentStrategy implements  PaymentStrategy{
    @Override
    public boolean pay(Booking booking) {
        return true;
    }
}
