package org.example.payment;

import org.example.model.PaymentResult;
import org.example.validation.ValidationUtilities;

public class PaypalPayment extends PaymentMethod {
    private final String email;
    // TODO: validate email
    // TODO: Add one payment method
    public PaypalPayment(String email) {
        super("PayPal");
        this.email = email;
    }

    @Override
    public PaymentResult processPayment(double amount) {
        if(ValidationUtilities.isValidEmail(this.email)){
            return new PaymentResult(true, "Paid " + amount + " using PayPal");
        }
        return new PaymentResult(false, "Invalid email");
    }
}
