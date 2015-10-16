package com.mechanitis.blog.upsource.customer;

import org.junit.Test;

public class CustomerDaoTest {
    @Test
    public void shouldCoverage() {
        CustomerDao customerDao = new CustomerDao();
        customerDao.getAllCustomerIds();
        customerDao.getCustomerById(1);
        customerDao.getAllCustomers();
    }

}