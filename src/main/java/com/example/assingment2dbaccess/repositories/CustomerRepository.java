package com.example.assingment2dbaccess.repositories;

import com.example.assingment2dbaccess.models.Customer;

import java.util.List;

public interface CustomerRepository extends CRUDRepository<Customer, Integer> {

    // Any extended methods can go here

    void test();


}
