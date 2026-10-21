package org.example.model;

public class FixedAmountDiscount extends Discount {
    private final int amount;

    public FixedAmountDiscount(String code, int amount){
        super(code);
        this.amount = amount;
    }

    @Override
    public double apply(double originalAmount) {
        return Math.max(0, originalAmount - amount);
    }

    // TODO
    // 'apply' formula: Math.max(0,originalAmount - amount)

}
