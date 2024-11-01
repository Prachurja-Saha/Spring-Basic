package com.practice.springbasic.springcore;

import com.practice.springbasic.SpringBasicApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TestIOCMain {

    public void build(){
        System.out.println(" Project is running ...");
    }
    public static void main(String[] args) {

        // This will Run the IOC container -> SpringApplication.run(SpringBasicApplication.class, args)
        /*
            IOC container itself is object so
        * In Spring, the IoC container has two main types:
        * 1. Bean Factory -> Basic IoC container in Spring
        * 2. Application Context -> advanced & widely used IoC container in Spring, & it builds on top of BeanFactory.
        *                           provides all the functionalities of BeanFactory.
        */

        ApplicationContext context;

        context = SpringApplication.run(SpringBasicApplication.class, args); // Returns Obj Of IOC High Level

        // Retrieving the object from IOC  assuming the Object is present in IOC
        // Here Bean is equivalent to object
        TestIOCMain testIOCMain = context.getBean(TestIOCMain.class);
        // we have to configure the class either by annotation, Xml configuration etc. to tell IOC to create object
        // or bean for this particular class. here we need to configure TestIoc class if not the object will not
        // present in IOC and will throw exception with message -> No qualifying Bean available.

        testIOCMain.build();

        /*
         Its working b/c in another main There is mention @SpringBootApplication which contains @ComponentScan
         @EnableAutoConfiguration , @Configuration
         b/c this class is in same package application will still run
         */
    }

}
