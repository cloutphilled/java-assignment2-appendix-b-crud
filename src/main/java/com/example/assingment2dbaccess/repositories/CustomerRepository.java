package com.example.assingment2dbaccess.repositories;

import com.example.assingment2dbaccess.models.Customer;

public interface CustomerRepository extends CRUDRepository<Customer, Integer> {

    // Any extended methods can go here

    void test();
}
