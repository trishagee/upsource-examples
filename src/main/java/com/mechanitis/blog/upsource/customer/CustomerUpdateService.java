package com.mechanitis.blog.upsource.customer;

public class CustomerUpdateService {
    public void addCustomer(int id, String firstName, String lastName) {
        CustomerRepository.CUSTOMERS.put(id, new Customer(id, firstName, lastName));
    }

    public void updateName(int id, String firstName, String lastName) {
        Customer customer = CustomerRepository.CUSTOMERS.get(id);
        if (customer != null) {
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
        }
    }
}
