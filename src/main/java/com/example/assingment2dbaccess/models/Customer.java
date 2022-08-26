package com.example.assingment2dbaccess.models;

/**
 * an immutable record class representing a customer.
 * @Author Peter Hansen, Christian Casper Hofma, Phillip Friis Petersen (Order after surname)
 */


public record Customer(int id,
                       String first_name, //represents the row first_name
                       String last_name, //represents the row last_name
                       String country, //represents the row country
                       String postal_code, //represents the row postal_code
                       String phone, //represents the row phone
                       String email) //represents the row email
  {
}
