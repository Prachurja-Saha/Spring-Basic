package com.practice.springbasic.springaop;

import org.springframework.stereotype.Component;

/**
 * <p style="color: white">
 * AOP: helps decoupling the cross-cutting concerns i.e. logging, security, transaction management etc. <br>
 * class containing the method known as Aspect and methods known as Advice
 * Every method is annotated with pointcut expression
 * </p>
 */
@Component
public class TestAopClass {

    public boolean test(String name){

        System.out.println("hi testing aop" + name);

        return true;
    }

}
