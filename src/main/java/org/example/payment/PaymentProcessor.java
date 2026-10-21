package org.example.payment;

import org.example.model.Order;
import org.example.model.PaymentResult;

public class PaymentProcessor {
    public PaymentResult process(Order order, PaymentMethod paymentMethod){
        // TODO: prevent paying already paid orders
        // TODO: prevent paying empty orders

        if(order.isPaid()){
            return new PaymentResult(false, "The order is already paid");
        }

        if(order.getItems().isEmpty()){
            return new PaymentResult(false, "The order is empty");
        }

        double totalSum = order.calculateTotal();

        if(totalSum < 0.0){
            return new PaymentResult(false, "Negative sum found");
        }

        PaymentResult result = paymentMethod.pay(totalSum);

        if(result.isSuccessful()){
            order.markAsPaid();
        }

        return result;
    }
}
