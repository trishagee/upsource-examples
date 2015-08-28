package com.mechanitis.blog.upsource.customer;

import org.junit.Test;

public class CustomerServiceTest {
    @Test
    public void shouldCoverage() {
        CustomerService customerService = new CustomerService(null);
        customerService.addCustomer(1, null, null);
        customerService.placeOrder(null, null);
    }

}