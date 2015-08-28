package com.mechanitis.blog.upsource.customer;

import java.math.BigDecimal;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private CustomerOrders orders;
    private int id;

    public Customer(int customerId, String firstName, String lastName) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void incrementOrders() {
        orders.setNumberOfOrders(orders.getNumberOfOrders() + 1);
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
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
}
