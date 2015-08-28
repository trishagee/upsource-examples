package com.mechanitis.blog.upsource.customer;

import com.mechanitis.blog.upsource.order.Order;
import com.mechanitis.blog.upsource.order.Warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.mechanitis.blog.upsource.customer.CustomerDao.doDatabaseErrorHandling;

public class CustomerService {
    private static final String INSERT_CUSTOMER_STATEMENT = "INSERT INTO Customers"
                                                            + "(id, first_name, last_name)"
                                                            + "VALUES"
                                                            + "( ?, ?, ? )";
    private Database database;

    public CustomerService(Database database) {
        this.database = database;
    }

    public void addCustomer(int id, String firstName, String lastName) {
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_CUSTOMER_STATEMENT)) {
            statement.setInt(1, id);
            statement.setString(2, firstName);
            statement.setString(3, lastName);

            statement.executeUpdate();
        } catch (SQLException e) {
            doDatabaseErrorHandling(e);
        }
    }

    public void placeOrder(Customer customer, Order order) {
        customer.incrementOrders();
        order.placeOrder(getWarehouse());
    }

    private Warehouse getWarehouse() {
        return null;
    }
}
