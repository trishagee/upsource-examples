package com.mechanitis.blog.upsource.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private final Database database = new Database();
    private ArrayList<Customer> customers;

    public List<Customer> getAllCustomers() {
        if (customers != null) {
            return customers;
        } else {
            customers = new ArrayList<>();
            try (Connection connection = database.getConnection();
                 PreparedStatement statement = connection.prepareStatement("SELECT * FROM Customers")) {
                try (ResultSet rs = statement.executeQuery()) {
                    rs.next();
                    customers.add(new Customer(
                            rs.getInt("id"),
                            rs.getString("first"),
                            rs.getString("last")
                    ));
                }
            } catch (SQLException e) {
                doDatabaseErrorHandling(e);
            }
            return customers;
        }
    }

    public List<Integer> getAllCustomerIds() {
        List<Integer> customerIds = new ArrayList<>();
        try (Connection connection = database.getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery("SELECT id FROM Customers")) {
                while (rs.next()) {
                    customerIds.add(rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            doDatabaseErrorHandling(e);
        }
        return customerIds;
    }

    public Customer getCustomerById(final int customerId) {
        return getCustomerByIdFromDatabase(customerId);
    }

    private Customer getCustomerByIdFromDatabase(int customerId) {
        Customer customer = null;
        try (Connection connection = database.getConnection();
             Statement statement = connection.createStatement()) {

            try (ResultSet rs = statement.executeQuery("SELECT * FROM Customers WHERE id = " + customerId)) {
                rs.next();
                customer = new Customer(
                        customerId,
                        rs.getString("first"),
                        rs.getString("last")
                );
            }

        } catch (SQLException e) {
            doDatabaseErrorHandling(e);
        }
        return customer;
    }

    private void doDatabaseErrorHandling(Exception e) {
        e.printStackTrace();
    }
}
