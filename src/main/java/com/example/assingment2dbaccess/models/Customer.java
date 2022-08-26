package com.example.assingment2dbaccess.models;

/**
 * a record customer class, which
 * @Author Peter Hansen, Christian Casper Hofma, Phillip Friis Petersen (Order after surname)
 */

public record Customer(int id,
                       String first_name,
                       String last_name,
                       String country,
                       String postal_code,
                       String phone,
                       String email) {
}
