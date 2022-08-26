package com.example.assingment2dbaccess.repositories;

import com.example.assingment2dbaccess.models.Customer;

import java.util.List;

/**
 *
 * @Author Peter Hansen, Christian Casper Hofma, Phillip Friis Petersen (Order after surname)
 */

public interface CRUDRepository<T,U> {
    List<T> findAll();
    Customer findById(U id);
    int insert(T object);
    int update(T object);
    int delete(T object);
    int deleteById(U id);
}
