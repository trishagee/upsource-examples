package com.mechanitis.blog.upsource.order;

import com.mechanitis.blog.upsource.customer.Customer;

import java.math.BigDecimal;

public class GiftCardOrder extends Order {
    private BigDecimal price;
    private Customer customer;

    public GiftCardOrder(Customer customer, BigDecimal price) {
        this.customer = customer;
        this.price = price;
    }

    @Override
    public void placeOrder(Warehouse warehouse) {
        customer.addBalanceToWallet(price);
    }

    @Override
    protected int getItemId() {
        return 0;
    }

}
