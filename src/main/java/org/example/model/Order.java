package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String customerName;
    private final List<OrderItem> items;
    private OrderStatus status;
    private Discount discount = new NoDiscount();

    public Order(Builder builder) {
        this.customerName = builder.customerName;
        this.items = builder.items;
        this.status = OrderStatus.NEW;
    }

    public void addItem(OrderItem item){
        // TODO: prevent adding items if order is already paid
        if(!this.isPaid()){
            items.add(item);
        }
    }

    public double calculateTotal(){
        // TODO: calculate total from all order items (including discounts)
        double total = 0;
        for(OrderItem item : this.items){
            total += discount.apply(item.calculateTotal());
        }
        return total;
    }

    public void markAsPaid(){
        // TODO: validate order is not empty
        if(!this.items.isEmpty()){
            this.status = OrderStatus.PAID;
        }
    }

    public void applyDiscount(Discount discount){
        this.discount = discount;
    }

    public boolean isPaid(){
        return this.status == OrderStatus.PAID;
    }

    public List<OrderItem> getItems() {
        return items;
    }
    public String getCustomerName() {
        return customerName;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private String customerName;
        private List<OrderItem> items = new ArrayList<>();
        public Builder customerName(String customerName){
            this.customerName = customerName;
            return this;
        }
        public Builder addItem(OrderItem item){
            this.items.add(item);
            return this;
        }
        public Order build(){
            // TODO: validate customerName
            if(this.customerName == null || this.customerName.length() <= 2){
                throw new IllegalArgumentException("The name is incorrect");
            }
            return new Order(this);
        }
    }
}
