package org.example.payment;

import org.example.model.PaymentResult;

public class GiftCardPayment extends PaymentMethod{
    private final String code;
    private double balance;

    public GiftCardPayment(String code, double balance) {
        // TODO: contructor
        super("GiftCard Master");
        this.code = code;
        this.balance = balance;
    }

    @Override
    public PaymentResult processPayment(double amount){
        // TODO: check if balance is enough
        if(balance < amount){
            return new PaymentResult(false, "Not enough money to do this operation");
        }

        return new PaymentResult(true, "Paid " + amount + " using gift card");
    }
}
