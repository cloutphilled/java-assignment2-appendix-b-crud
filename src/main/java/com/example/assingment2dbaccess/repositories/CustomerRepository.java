package com.example.assingment2dbaccess.repositories;

import com.example.assingment2dbaccess.models.Customer;

import java.util.List;

/**
 *
 * @Author Peter Hansen, Christian Casper Hofma, Phillip Friis Petersen (Order after surname)
 */

public interface CustomerRepository extends CRUDRepository<Customer, Integer> {


    List<Customer> findACustomerById(Integer id); // A method that finds customer by id. Takes an Integer as parameter..


    List<Customer> findACustomerByName(String name); //A method that finds a customer by name. Takes a string name as parameter

    void test(); //A method that tests the connection to the db and prints it out if it succeeds.


}
