package com.practice.springbasic.springcore.types_of_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class DITest{}

@Component
public class Test {

    private final DITest diTest; // final -> I don't want to change this instance / so I can't use setter injection
    private DITest diTest2; // Here I can use setter injection

    @Autowired                // Use Java Reflection API
    private DITest diTest3;  // Field Injection Not Recommended

    Test(DITest diTest){       // Constructor Injection -> Recommended
        this.diTest = diTest;
    }

    @Autowired
    public void setDI(DITest diTest) { // Setter Injection Not Recommended
        this.diTest2 = diTest;
    }


    /*
     * Constructor Injection: Dependencies are provided through a class constructor.
     * Setter Injection: Dependencies are provided through setter methods after the object is created.
     * Interface Injection: The dependency provides an injector method that will inject the
     *                      dependency into any client that passes itself (the client) to the injector.
     * Field Injection: Dependencies are directly injected into the fields of a class, typically using
     *                  Java reflection.
     */

    // if you use constructor injection in a service, the Inversion of Control (IoC) container will inject the service
    // instance into the controller at the time of the controller's instantiation.
    // The container manages the lifecycle of the objects and ensures that all dependencies are satisfied before the
    // controller is used. but need to configure that class [need to mention IOC to create and store obj of that class]
}
