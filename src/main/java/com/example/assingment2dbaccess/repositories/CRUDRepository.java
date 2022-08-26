package com.example.assingment2dbaccess.repositories;

import com.example.assingment2dbaccess.models.Customer;

import java.util.List;

/**
 * A repository service (of class interface) that provides access
 * to all entities and value objects. This service is a
 * generic repository to encapsulate CRUD.
 *
 * It is of type list which takes
 *
 * @param <T> The type of table is inserted here.
 * @param <U> The ID of the table of type Integer
 *
 * @Author Peter Hansen, Christian Casper Hofma, Phillip Friis Petersen (Order after surname)
 */

public interface CRUDRepository<T,U> {
    List<T> findAll(); //a list that finds all available entities in database
    Customer findById(U id); //get a single entity based on the type of table and its id defined in class CustomerRepository
    int insert(T object); //inserts a single entity based on the object T defined in class CustomerRepository
    int update(T object); //updates a single entity based on the object T defined in class CustomerRepository
    int delete(T object); //deletes a single entity based on the object T defined in class CustomerRepository
    int deleteById(U id); //delete a single entity based on the type of table and its id defined in class CustomerRepository
}
