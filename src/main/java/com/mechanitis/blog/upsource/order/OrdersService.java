package com.mechanitis.blog.upsource.order;

import com.mechanitis.blog.upsource.customer.Customer;
import com.mechanitis.blog.upsource.customer.CustomerRepository;

public class OrdersService {
    private OrdersDao ordersDao;
    private CustomerRepository customerRepository;

    public void placeOrder(BookOrder order) {
        ordersDao.saveOrder(order);
        Customer customer = customerRepository.get(order.getCustomerId());
        customer.incrementOrders();
    }
}
