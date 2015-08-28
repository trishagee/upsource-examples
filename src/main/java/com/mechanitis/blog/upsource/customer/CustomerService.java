package com.mechanitis.blog.upsource.customer;

import com.mechanitis.blog.upsource.order.Order;
import com.mechanitis.blog.upsource.order.Warehouse;

public class CustomerService {
    public void placeOrder(Customer customer, Order order) {
        customer.incrementOrders();
        order.placeOrder(getWarehouse());
    }

    private Warehouse getWarehouse() {
        return null;
    }
}
