package com.example.assingment2dbaccess;

import com.example.assingment2dbaccess.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ChinookAppRunner implements ApplicationRunner {

    /*private final ChinookDAO chinookDAO;


    @Autowired
    public ChinookAppRunner(ChinookDAO chinookDAO){
        this.chinookDAO = chinookDAO;


    }*/

    private final CustomerRepository customerRepository;

    @Autowired
    public ChinookAppRunner(CustomerRepository customerRepository){

        this.customerRepository = customerRepository;

    }

    /**
     * @param args incoming application arguments
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //chinookDAO.test();
        //System.out.println(Arrays.toString(customerRepository.findAll().toArray()));
        //chinookDAO.getAllActors();
        //customerRepository.findAll();

        //Requirement one
        //customerRepository.findAll().forEach(System.out::println);

        //Requirement two
        //customerRepository.findById(1).forEach(System.out::println);




    }
}
