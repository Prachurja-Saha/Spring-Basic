package com.practice.springbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBasicApplication {

    public static void main(String[] args) {

        ApplicationContext context;

        context = SpringApplication.run(SpringBasicApplication.class, args); // Returns Obj Of IOC High Level
                                                                             // Type is Application Context

    }

}
