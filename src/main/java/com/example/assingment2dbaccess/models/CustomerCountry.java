package com.example.assingment2dbaccess.models;


/**
 * an immutable record class representing a customer and his/her related country.
 * @Author Peter Hansen, Christian Casper Hofma, Phillip Friis Petersen (Order after surname)
 */

public record CustomerCountry(int id,

                              String first_name, //represents the row first_name

                              String last_name, //represents the row last_name

                              String country)  //represents the row country

{
}
