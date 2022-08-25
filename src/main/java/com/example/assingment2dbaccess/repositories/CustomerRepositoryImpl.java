package com.example.assingment2dbaccess.repositories;

import com.example.assingment2dbaccess.models.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{


    private final String url;
    private final String username;
    private final String password;

    public CustomerRepositoryImpl(
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * @return
     */
    @Override
    public List<Customer> findAll() {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Customer findById(Integer id) {
        return null;
    }

    /**
     * @param object
     * @return
     */
    @Override
    public int insert(Customer object) {
        return 0;
    }

    /**
     * @param object
     * @return
     */
    @Override
    public int update(Customer object) {
        return 0;
    }

    /**
     * @param object
     * @return
     */
    @Override
    public int delete(Customer object) {
        return 0;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    /**
     *
     */
    @Override
    public void test() {
        try (Connection conn = DriverManager.getConnection(url, username, password);) {
            System.out.println("Connected to Postgres...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
