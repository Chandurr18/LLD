package strategy.payment;

import model.Booking;

public class UpiPaymentStrategy implements  PaymentStrategy{
    @Override
    public boolean pay(Booking booking) {
        return true;
    }
}
