package com.example.assingment2dbaccess;

import com.example.assingment2dbaccess.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

/**
 * The application runner which implements the ApplicationRunner.
 * It is used to indicate that a bean should run when it is contained
 * within a SpringApplication.
 *
 * @Component: it is used to instantiate configuration- and classpath scanning
 *
 * @Author Peter Hansen, Christian Casper Hofma, Phillip Friis Petersen (Order after surname)
 */

@Component
public class ChinookAppRunner implements ApplicationRunner {

    private final CustomerRepository customerRepository; //The CustomerRepository is instantiated here.

    /**
     * The constructor takes the customerRepository as a parameter and initializes it.
     * @param customerRepository
     */
    @Autowired
    public ChinookAppRunner(CustomerRepository customerRepository){

        this.customerRepository = customerRepository; //saves the parameter to the final variable.

    }

    /**
     * @param args incoming application arguments
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //chinookDAO.test();


        //Requirement one is instantiated here
        //customerRepository.findAll().forEach(System.out::println);

        //Requirement two is instantiated here
        customerRepository.findACustomerById(1).forEach(System.out::println);

        //Requirement three




    }
}
