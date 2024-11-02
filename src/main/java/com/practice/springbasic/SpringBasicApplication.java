package com.practice.springbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBasicApplication {

    public static void main(String[] args) {

        ApplicationContext context; // Type of IOC container

        context = SpringApplication.run(SpringBasicApplication.class, args); // Returns Obj Of IOC High Level
                                                                             // Type is Application Context


/*        Application Context: The Application Context is a more advanced and feature-rich version of the
          IoC container.
          While both the Application Context and the basic IoC container (like BeanFactory) provide support
          for dependency injection, the Application Context includes additional capabilities, such as:
                Event Handling: It can publish and listen for events.
                Internationalization (i18n): It supports message resources for localization.
                Bean Post Processors: It allows for customization of beans after their instantiation.
                AOP Support: It integrates with Spring’s Aspect-Oriented Programming features.
 */

    }

}
