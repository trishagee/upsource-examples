package com.mechanitis.blog.upsource.customer;

@SuppressWarnings("unused") //this is phase 1 of development. Code should be used when ISSUE-2574 is done.
public class CustomerOrders {
    private int numberOfOrders;

    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(int numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }
}
