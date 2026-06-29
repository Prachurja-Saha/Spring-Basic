package com.practice.springbasic.springcore.ioc_and_di.types_of_di;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ConstructorInjection { // Spring Container calls the constructor for di

    /*
    * As of Spring Framework 4.3, an @Autowired annotation on such a constructor is no longer necessary if the target
    * bean defines only one constructor to begin with. However,if several constructors are available and there is no
    * primary/default constructor, at least one of the constructors must be annotated with @Autowired in order
    * to instruct the container which one to use. See the discussion on constructor resolution for details.
    * */


        // The object of the interface IGeek
        private final IGeek dependency;

        // Constructor to set the CDI
        public ConstructorInjection(IGeek geek) {//we have to mention which object to inject either by annotation or configuration
            this.dependency = geek;               // there should be class that implement geek interface we have to mention
                                                 // that either by annotation or configuration
        }

       interface IGeek {
          int save1(); // abstract method
       }

       @Service // The @Service annotation won’t work properly inside another class unless the inner class is static.
       static class test2 implements IGeek {
            @Override
            public int save1() {
                System.out.println("Test2");
                return 0;
            }
       }

       // if there is multiple bean (multiple class which implement IGeek and there is annotation @Service or configured)
      // Spring conatiner will confuse which bean/obj to inject so for that we have to mention qualifier with id

}
