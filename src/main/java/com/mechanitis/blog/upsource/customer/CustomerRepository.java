package com.mechanitis.blog.upsource.customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepository {
    private static final Map<Integer, Customer> CUSTOMERS = new HashMap<>();

    public Customer get(int customerId) {
        Customer customer = CUSTOMERS.get(customerId);
        if (customer == null) {
            throw new InvalidCustomerException();
        }
        return customer;
    }

    public void add(Customer customer) {
        CUSTOMERS.put(customer.getId(), customer);
    }
}
