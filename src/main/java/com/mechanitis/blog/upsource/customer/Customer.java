package com.mechanitis.blog.upsource.customer;

import java.math.BigDecimal;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;

    public Customer(int customerId, String firstName, String lastName) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addBalanceToWallet(BigDecimal price) {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return customerId;
    }
}
