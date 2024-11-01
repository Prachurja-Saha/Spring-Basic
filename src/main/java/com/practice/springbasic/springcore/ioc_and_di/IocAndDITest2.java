package com.practice.springbasic.springcore.ioc_and_di;

class Burger implements Food {}

interface Food{}

class Pizza implements Food {}

public class IocAndDITest2 {

    Food food;

    // Without DI
    IocAndDITest2(){
        food = new Burger(); // Here IocAndDITest2 is dependent on Burger
                            // if I want Pizza implementation I can't use that
                            // either Burger or Pizza
                            // DI is solved this issue
        /* Tight Coupling*/
    }

    // With DI
    IocAndDITest2(Food food){ // IOC container finds its Object/ Object implementation by @Component
        food = this.food; // Now here IocAndDITest2 is not dependent we can use both Pizza/Burger
    }/* This is also use abstraction Here Food is interface implementation is hided*/
    /* Annotation -> if there is single implementation IOC will inject automatically i.e. repository */

    public void apply(){

        Food food1 = new Burger();
        Food food2 = new Pizza();
        IocAndDITest2 iocAndDITest2 = new IocAndDITest2(food1); // we have flexibility
        IocAndDITest2 iocAndDITest21 = new IocAndDITest2(food2);// we have flexibility
    }

}
