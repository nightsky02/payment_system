package org.example.payment;

import org.example.model.PaymentResult;
import org.example.validation.ValidationUtilities;

public class ApplePayPayment extends PaymentMethod{
    private String appleId;

    public ApplePayPayment(String appleId){
        super("Apple inc.");
        this.appleId = appleId;
    }
    @Override
    public PaymentResult processPayment(double amount) {
        if(ValidationUtilities.isValidEmail(this.appleId)){
            return new PaymentResult(true, "Successfully paid " + amount + " by ApplePay");
        }
        return new PaymentResult(false, "Invalid email");
    }
}
