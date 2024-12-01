package com.practice.springbasic.springaop;

import com.practice.springbasic.SpringBasicApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AopSpringMain {

    public static void main(String[] args){

        ApplicationContext context;

        context = SpringApplication.run(SpringBasicApplication.class, args);
        context.getBean(TestAopClass.class).test("Amit");


    }

}
