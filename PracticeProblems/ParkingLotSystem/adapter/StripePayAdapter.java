package adapter;

public class StripePayAdapter implements PaymentServiceAdapter{

    @Override
    public void pay(double amount) {
        // Pay using StripePay;
    }
}
