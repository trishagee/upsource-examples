package com.mechanitis.blog.upsource.order;

import com.mechanitis.blog.upsource.customer.Customer;
import com.mechanitis.blog.upsource.customer.CustomerRepository;

public class OrdersService {
    private OrdersDao ordersDao;

    public void placeOrder(Order order) {
        ordersDao.saveOrder(order);
        Customer customer = CustomerRepository.CUSTOMERS.get(order.getCustomerId());
        customer.incrementOrders();
    }
}
