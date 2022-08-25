package com.example.assingment2dbaccess;

import com.example.assingment2dbaccess.models.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

        public List<Customer> getAllCustomers() {
            String sql = "SELECT * FROM customer";
            List<Customer> customers = new ArrayList<>();
            try(Connection conn = DriverManager.getConnection(url, username,password)) {
                // Write statement
                PreparedStatement statement = conn.prepareStatement(sql);
                // Execute statement
                ResultSet result = statement.executeQuery();
                // Handle result
                while(result.next()) {
                    Customer student = new Customer(
                            result.getInt("customer_id"),
                            result.getString("first_name"),
                            result.getString("last_name"),
                            result.getString("company"),
                            result.getString("address"),
                            result.getString("city"),
                            result.getString("state"),
                            result.getString("country"),
                            result.getString("postal_code"),
                            result.getString("phone"),
                            result.getString("fax"),
                            result.getString("email")
                    );
                    customers.add(student);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return customers;
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
                statement.setString(4,customer.company());
                statement.setString(5,customer.address());
                statement.setString(6,customer.city());
                statement.setString(7,customer.state());
                statement.setString(8,customer.country());
                statement.setString(9,customer.postal_code());
                statement.setString(10,customer.phone());
                statement.setString(11,customer.fax());
                statement.setString(12,customer.email());
                // Execute statement
                result = statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        }
}


