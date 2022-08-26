package com.example.assingment2dbaccess;

import com.example.assingment2dbaccess.models.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Author Peter Hansen, Christian Casper Hofma, Phillip Friis Petersen (Order after surname)
 */

@Component
public class ChinookDAO {
        @Value("${spring.datasource.url}")
        private String url;
        @Value("${spring.datasource.username}")
        private String username;
        @Value("${spring.datasource.password}")
        private String password;


        public void test() {
            try (Connection conn = DriverManager.getConnection(url, username, password);) {
                System.out.println("Connected to Postgres...");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        /*public void getAllCustomers() {
            String sql = "SELECT * FROM customer;";
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                // Write statement
                PreparedStatement statement = conn.prepareStatement(sql);
                // Execute statement
                ResultSet result = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/

        public void getSpecificCustomer(int id) {
            String sql = "SELECT * FROM customer WHERE customer_id = ?";
            try(Connection conn = DriverManager.getConnection(url, username,password)) {
                // Write statement
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, id);
                // Execute statement
                ResultSet result = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public int insert(Customer customer) {
            String sql = "INSERT INTO customer VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            int result = 0;
            try(Connection conn = DriverManager.getConnection(url, username,password)) {
                // Write statement
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, customer.id());
                statement.setString(2,customer.first_name());
                statement.setString(3,customer.last_name());
                statement.setString(8,customer.country());
                statement.setString(9,customer.postal_code());
                statement.setString(10,customer.phone());
                statement.setString(12,customer.email());
                // Execute statement
                result = statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        }
}


