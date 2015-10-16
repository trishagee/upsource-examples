package com.mechanitis.blog.upsource.customer;

import org.junit.Assert;
import org.junit.Test;

public class CustomerDaoTest {

    private static final int ID_OF_CUSTOMER_THAT_DOES_NOT_EXIST = 7547854;

    @Test
    public void shouldCoverage() {
        CustomerDao customerDao = new CustomerDao();
        customerDao.getAllCustomerIds();
        customerDao.getAllCustomers();
    }

    @Test
    public void shouldThrowAnExceptionWhenCustomerNotFound() {
        // given
        CustomerDao customerDao = new CustomerDao();

        // expect
        try {
            customerDao.getCustomerById(ID_OF_CUSTOMER_THAT_DOES_NOT_EXIST);
            Assert.fail("Should have thrown an Exception");
        } catch (CustomerNotFoundException e) {
            // this is expected
        }
    }

}