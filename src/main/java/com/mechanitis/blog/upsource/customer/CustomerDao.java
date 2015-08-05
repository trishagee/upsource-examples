package com.mechanitis.blog.upsource.customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private final Database database = new Database();


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

    private void doDatabaseErrorHandling(Exception e) {
        e.printStackTrace();
    }
}
