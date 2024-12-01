package com.practice.springbasic.springcore.types_of_configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* This is java based configuration using annotation -> @configuration*/
@Configuration  // using this annotation we are allowing this class to create bean
public class BeanTest {

    @Bean
    public MyClass newBean() {
        return new MyClass();
    }

}
