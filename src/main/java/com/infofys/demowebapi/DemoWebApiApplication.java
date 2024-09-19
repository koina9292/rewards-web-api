package com.infofys.demowebapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot RESTFul webapi calculates reward points for provided transactions
 */
@SpringBootApplication
public class DemoWebApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoWebApiApplication.class, args);
    }

}
