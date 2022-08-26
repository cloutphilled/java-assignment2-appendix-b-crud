package com.example.assingment2dbaccess.repositories;

import com.example.assingment2dbaccess.models.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements the CustomerRepository and thus the global CRUDRepository.
 * @Author Peter Hansen, Christian Casper Hofma, Phillip Friis Petersen (Order after surname)
 */

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{


    private final String url; //A final string that contains the URL to the DB
    private final String username; //A final string that contains the username to the DB
    private final String password; //A final string that contains the password to the DB

    /**
     * A constructor that initializes the connection to the DB.
     * @param password: takes the password
     * @param username: takes the username
     * @param url: takes the username
     * @Value("${spring.datasource.url}"): takes the URL-value from the application.properties and
     * assigns it to the String url
     * @Value("postgres"): takes the string postgres from the application.properties and
     * assigns it to the String username
     * @Value("postgres"): takes the string postgres from the application.properties and
     * assigns it to the String password
     *
    * */
    public CustomerRepositoryImpl(
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * An override method that returns all the customers from the record customer.
     * @return a list of type customer
     */
    @Override
    public List<Customer> findAll() {
        String sql = "SELECT * FROM customer"; //An SQL-statement that selects all from table customer and saves it to sql.
        List<Customer> customers = new ArrayList<>(); //A list of type customer named customers.

        //a try and catch statement which tries to connect to DB using the parameters, url, username and password
        try(Connection conn = DriverManager.getConnection(url, username,password)) {

            // A statement that takes the query from the variable sql.
            PreparedStatement statement = conn.prepareStatement(sql);
            // Executes the resultset
            ResultSet result = statement.executeQuery();

            // Handles the ResultSet object reference by iterating through it. Stops when all the parameters of the construtor customer is initialized.
            while(result.next()) {
                //A customer object reference of the type record is created.
                Customer customer = new Customer(
                        result.getInt("customer_id"), // The variable is then fetched and saved in the resultSet object reference using get-methods.
                        result.getString("first_name"), // The variable is then fetched and saved in the resultSet object reference using get-methods.
                        result.getString("last_name"), // The variable is then fetched and saved in the resultSet object reference using get-methods.
                        result.getString("country"), // The variable is then fetched and saved in the resultSet object reference using get-methods.
                        result.getString("postal_code"), // The variable is then fetched and saved in the resultSet object reference using get-methods.
                        result.getString("phone"), // The variable is then fetched and saved in the resultSet object reference using get-methods.
                        result.getString("email") // The variable is then fetched and saved in the resultSet object reference using get-methods.
                );
                //Adds the initialized object to the previously defined list
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Returns the list of type customer containing the customer-object.
        return customers;
    }

    /**
     * Not used....
     * @param id
     * @return
     */
    @Override
    public Customer findById(Integer id) {
        return null;
    }

    /**
     * A method that finds a customer by a tables primary key id.
     * @param id
     * @return a list of type customer
     */
    @Override
    public List<Customer> findACustomerById(Integer id) {
        String sql = "SELECT * FROM customer WHERE customer_id = ?"; //An sql statement that selects all from the table customer where customer id is defined by the parameter of the method, id.
        List<Customer> customers = new ArrayList<>(); //A list of type customer named customers.

        //a try and catch statement which tries to connect to DB using the parameters, url, username and password
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // A statement that takes the query from the variable sql.
            PreparedStatement statement = conn.prepareStatement(sql);
            // Then the object is used by calling the setInt method. The parameterIndex is set to 1 and secondly takes the input parameter of the method, id
            statement.setInt(1, id);
            // The statement is then executed
            ResultSet result = statement.executeQuery();
            // The result is handled by going through the result object.
            while (result.next()) {
                //A customer object reference of the type record is created.
                Customer customer = new Customer(
                        result.getInt("customer_id"),  // The variable is then fetched and saved in the resultSet object reference using get-methods.
                        result.getString("first_name"),  // The variable is then fetched and saved in the resultSet object reference using get-methods.
                        result.getString("last_name"),  // The variable is then fetched and saved in the resultSet object reference using get-methods.
                        result.getString("country"),   // The variable is then fetched and saved in the resultSet object reference using get-methods.
                        result.getString("postal_code"),  // The variable is then fetched and saved in the resultSet object reference using get-methods.
                        result.getString("phone"),  // The variable is then fetched and saved in the resultSet object reference using get-methods.
                        result.getString("email")  // The variable is then fetched and saved in the resultSet object reference using get-methods.
                );
                //Adds the initialized object to the previously defined list
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    /**
     * A method that should finds a customer by a name. (DOES NOT WORK)
     * @param name
     * @return
     */
    @Override
    public List<Customer> findACustomerByName(String name) {
        String sql = "SELECT * FROM customer WHERE first_name LIKE 'L%' = ?";
        List<Customer> customers = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            //statement.setCursorName(?);
            // Execute statement
            ResultSet result = statement.executeQuery();
            // Handle result
            while (result.next()) {
                Customer customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }



    /**
     * Not used
     * @param customer
     * @return
     */
    @Override
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

    /**
     * Not used
     * @param object
     * @return
     */
    @Override
    public int update(Customer object) {
        return 0;
    }

    /**
     * Not used
     * @param object
     * @return
     */
    @Override
    public int delete(Customer object) {
        return 0;
    }

    /**
     * Not used
     * @param id
     * @return
     */
    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    /**
     * A test method that is used to check if the connection to DB works.
     */
    @Override
    public void test() {
        //A connection object reference that takes the url, username and password.
        //It is created with a try catch to catch any errors.
        try (Connection conn = DriverManager.getConnection(url, username, password);) {
            System.out.println("Connected to Postgres...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
