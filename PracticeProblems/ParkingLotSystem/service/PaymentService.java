package service;

import adapter.PaymentServiceAdapter;

public class PaymentService {
    private final PaymentServiceAdapter paymentServiceAdapter;
    public PaymentService(PaymentServiceAdapter paymentServiceAdapter){
        this.paymentServiceAdapter = paymentServiceAdapter;
    }

    public boolean processPayment(double amount){
        try{
            paymentServiceAdapter.pay(amount);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
