package com.example.assingment2dbaccess;

import com.example.assingment2dbaccess.models.Customer;
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
     * Here the repository methods are run and printed out to the console.
     * @param args incoming application arguments
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Requirement one is instantiated here
        customerRepository.findAll().forEach(System.out::println);

        //Requirement two is instantiated here
        customerRepository.findACustomerById(1).forEach(System.out::println);

        //Requirement three is instantiated here (does not work)


        //Requirement four is instantiated here
        customerRepository.sortCustomerByLastName(4);

        //Requirement five is instantiated here. The below test has not been added to DB yet.
        /*customerRepository.insert(new Customer(61,
                "Svend",
                "Svendsen",
                "Denmark",
                "4000",
                "+45 12 34 56 71",
                "svend@svendsen.dk"));*/

        //Requirement six is instantiated here

        //Requirement seven could not figure it out

        //Requirement eight could not figure it out

        //Requirement nine could not figure it out





    }
}
