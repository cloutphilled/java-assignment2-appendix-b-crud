package com.example.assingment2dbaccess.models;

/**
 * an immutable record class representing a customer and a genre.
 * @Author Peter Hansen, Christian Casper Hofma, Phillip Friis Petersen (Order after surname)
 */

public record CustomerGenre(int id,
                            String first_name, // represents the row first_name
                            String last_name, // represents the row last_name
                            String genre) // represents the row genre
                            {
}
