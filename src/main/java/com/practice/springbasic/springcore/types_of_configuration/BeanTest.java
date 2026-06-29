package com.practice.springbasic.springcore.types_of_configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* This is java based configuration using annotation -> @configuration*/
/* The @Bean annotation tells the Spring container to create an instance of the return type of the method and manage
it as a Spring bean.*/
@Configuration  // using this annotation we are allowing this class to create bean
public class BeanTest {

    @Bean
    public MyClass newBean() {
        return new MyClass();
    }

    @Bean
    public MyClass newBean2() {
        return new MyClass();
    }

    /*
    * Here are a few reasons why we use @Bean:
    * Explicit Configuration: With @Bean, you can explicitly declare a bean in the Java configuration.
    * This makes the configuration more readable and provides greater control over the bean lifecycle.
    *
    * Dependency Injection: It allows you to inject dependencies into your beans through constructor or setter injection.
    * Custom Initialization: You can define custom initialization and destruction methods for beans.
    * */

    // Why We USE BEAN part 2 sometimes instead of @Component, @Service etc.
    /*
    * Fine-Grained Control: With @Bean, you have more control over the bean creation process. You can configure complex
    * initialization, and destruction methods, or even create beans based on runtime conditions.
    *
    * External Libraries: When you need to configure beans from external libraries, and you cannot modify the source
    * code to add @Component or @Service, using @Bean in a @Configuration class is the way to go.
    *
    * Legacy Code: If you're working with legacy code that doesn't follow Spring's component scanning conventions,
    * you can use @Bean to integrate those classes into the Spring context.
    *
    * Multiple Beans of the Same Type: If you need to define multiple beans of the same type but with different
    * configurations, @Bean gives you the flexibility to do so.
    *
    *   @Configuration
        public class AppConfig {

            @Bean
            public DataSource primaryDataSource() {
                // Configure and return the primary DataSource
            }

            @Bean
            public DataSource secondaryDataSource() {
                // Configure and return the secondary DataSource
            }
        }
        * In this case, primaryDataSource and secondaryDataSource are two different beans of the same type (DataSource),
        * but with different configurations.@Component and @Service are usually used for straightforward bean
        * definitions where you don't need such fine-grained control.
    * */


//public class BeanTwo {
//     public void init() {
//        System.out.println("BeanOne is initialized");
//    }
// }
//public class BeanTwo {
//    public void cleanup() {
//        System.out.println("BeanTwo is being destroyed");
//    }
//}

    // 	@Bean(initMethod = "init") // It will call init method after the bean is created and dependencies are injected.
    //	public BeanOne beanOne() {
    //		return new BeanOne();
    //	}
    //
    //	@Bean(destroyMethod = "cleanup") // This method is called before the bean is removed from the Spring context.
    //	public BeanTwo beanTwo() {
    //		return new BeanTwo();
    //	}

}
