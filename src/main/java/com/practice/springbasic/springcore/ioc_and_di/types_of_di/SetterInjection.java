package com.practice.springbasic.springcore.ioc_and_di.types_of_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class SetterInjection {

    /* 1 */
    // If you use @Autowired on a setter method, you do not need to call that setter manually.
    // Spring will automatically call the setter and inject the dependency when it creates the bean.
    @Component
    static class Car {

        private Enginee engine;

        @Autowired
        public void setEngine(Enginee engine) { // Spring calls this automatically
            this.engine = engine;
        }
    }

     /* 2 */
    // If u mention @Autowired in setter method and if no bean found then there will be exception
    // so we can make it optional using @Autowired(required=false) if there is no bean it will be null
    // We can call setter method from anywhere and explicitly and inject object (here spring will not inject)

    /* 3 */
    // And if u dont mention autowired than IOC container will not call setter method
    // If you don't use @Autowired and call the setter manually, you are handling dependency injection yourself, not Spring.
    // Spring will not inject anything into the setter method, making it behave like a regular Java class.
    // You must manually call the setter in your code, or You must define the injection explicitly in
    // configuration (e.g., XML or @Bean method). Code Example->
    /*
        @Component
        public class Car {
        private Engine engine;

             public void setEngine(Engine engine) { // Spring will NOT call this automatically
               this.engine = engine;
               }
        }

         Car car = new Car();
         car.setEngine(new Engine());

       @Configuration
       class AppConfig {
            @Bean
            public Car car(Engine engine) {
                Car car = new Car();
                car.setEngine(engine);
                return car;
             }
       }


    */
}

class Enginee {

}