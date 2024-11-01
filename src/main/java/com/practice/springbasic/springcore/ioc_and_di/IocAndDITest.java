package com.practice.springbasic.springcore.ioc_and_di;

/* Without Ioc/DI and annotation */
class Service0 {
    Service1 service1;
    public Service0(Service1 service1){
        this.service1 = service1; // Here some needs to create an object of Service1 and pass in Service0
                                  // Below is the answer
        /*
                Controller(Service1 s, Service2 s2){ this.s = s; this.s2 = s2 }
                Q1. who is creating obj of Controller and injecting object of service1 and 2
                does IOC ?
                Ans: Yes
                the IoC container creates the Controller object and injects the necessary dependencies
                (Service1 and Service2).This is done based on the constructor or other injection mechanisms
                (like setter injection or field injection).

                Q2. while Creating obj of controller does it create obj of others Services
                i.e. new Controller(new Service1(new other services), new Service2(new Other Services)) ?
                Ans: Yes but not using new keyword IoC container uses Java’s reflection API
                with other advanced instantiation mechanisms.
                IoC container checks if Service1 and Service2 are already available in the container
                If they are available, the container injects existing instances of Service1 and Service2
                into Controller.
                If they aren’t available, the container creates instances of Service1 and Service2
                based on the xml configuration or annotation

                Dependency Injection (DI)
                is the process where the IoC container provides the dependencies(or objects)
                that a class needs

                IoC
                is the concept where the control of object creation and management is transferred from the
                class itself to an external entity (the IoC container).
                _____________________________
        JVM->   |  IOC:[ object1, Object2...]|
                |____________________________|

*/
    }

}

class Service1 {
    private Service2 service2;

    // To create Service2 We have to create object
    Service1(Service2 service2){
        this.service2 = service2;  // Somewhere we have to create an object of Service2 and pass here
                                   // either Service0 or Here in Service1
    }

}

class Service2 { }


public class IocAndDITest {}
