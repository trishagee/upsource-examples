package com.mechanitis.blog.upsource.customer;

public class CustomerUpdateService {
    private CustomerRepository customerRepository;

    public void addCustomer(int id, String firstName, String lastName) {
        customerRepository.add(new Customer(id, firstName, lastName));
    }

    public void updateName(int id, String firstName, String lastName) {
        Customer customer = customerRepository.get(id);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
    }
}
