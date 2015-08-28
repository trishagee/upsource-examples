package com.mechanitis.blog.upsource.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDao {
    private final Database database = new Database();
    private ArrayList<Customer> customers;

    public Customer getCustomerById(final int customerId) {
        if (customers != null) {
            Optional<Customer> customerWithId = customers.stream()
                                                         .filter(customer -> customer.getId() == customerId)
                                                         .findFirst();
            return customerWithId.orElseGet(() -> getCustomerByIdFromDatabase(customerId));
        }
        return getCustomerByIdFromDatabase(customerId);
    }

    public List<Customer> getAllCustomers() {
        if (customers != null) {
            return customers;
        } else {
            customers = new ArrayList<>();
            try (Connection connection = database.getConnection();
                 PreparedStatement statement = connection.prepareStatement("SELECT * FROM Customers ORDER BY id")) {
                try (ResultSet rs = statement.executeQuery()) {
                    rs.next();
                    customers.add(extractCustomer(rs));
                }
            } catch (SQLException e) {
                doDatabaseErrorHandling(e);
            }
            return customers;
        }
    }

    private Customer extractCustomer(ResultSet rs) throws SQLException {
        return new Customer(
                rs.getInt("id"),
                rs.getString("first"),
                rs.getString("last")
        );
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

    public void saveCustomer(Customer customer) {
        try (Connection connection = database.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO Customers"
                              + "(id, first_name, last_name)"
                              + "VALUES"
                              + "(" + customer.getId() + ", " + customer.getFirstName() + ", " + customer.getLastName()
                              + ");");
        } catch (SQLException e) {
            doDatabaseErrorHandling(e);
        }
    }
}
