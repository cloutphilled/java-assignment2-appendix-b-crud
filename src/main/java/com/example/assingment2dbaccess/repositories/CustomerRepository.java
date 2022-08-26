package com.example.assingment2dbaccess.repositories;

import com.example.assingment2dbaccess.models.Customer;

import java.util.List;

/**
 *
 * @Author Peter Hansen, Christian Casper Hofma, Phillip Friis Petersen (Order after surname)
 */

public interface CustomerRepository extends CRUDRepository<Customer, Integer> {

    // A method that finds customer by id
    List<Customer> findACustomerById(Integer id);

    //A method that finds a customer by name
    List<Customer> findACustomerByName(String name);

    void test();


}
