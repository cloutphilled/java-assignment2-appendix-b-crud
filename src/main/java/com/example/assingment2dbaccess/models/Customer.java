package com.example.assingment2dbaccess.models;

public record Customer(int id,
                       String first_name,
                       String last_name,
                       String company,
                       String address,
                       String city,
                       String state,
                       String country,
                       String postal_code,
                       String phone,
                       String fax,
                       String email) {
}