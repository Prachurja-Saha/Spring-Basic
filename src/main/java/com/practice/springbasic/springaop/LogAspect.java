package com.practice.springbasic.springaop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
/**
 *  Here We are using AspectJ
 */
@Log4j2
@Component
@Aspect
public class LogAspect {

    /*
    *  I cant store PointCut expression in String i.e.
    *  String expression = "execution(public boolean com.practice.springbasic.springaop.TestAopClass.test(String))"
    *  and then use expression everywhere
    *
    *  but to make generic I have to create pointcut expression using @pointcut annotation
    *
    *  for all class, all method or all return type use * expression
    *  and in parameter we can use var arg i.e. (..)
    *  for all -> expression(public * *.*.*(..))
    *  you dont need to mention modifier it's optional by default it will be public
    * */

    @Pointcut("execution(public boolean com.practice.springbasic.springaop.TestAopClass.test(String))")
    public void customPointCut(){
        // now we can replace  "execution(public boolean com.practice.springbasic.springaop.TestAopClass.test(String))"
        // with "customPointCut()" example shown in logBeforeAdvice
    }


    // method execution time
    // execution(<modifiers><return-type> <class-name>.<method-name>(parameters)
    @Before("customPointCut()") // pointcut expression
    public void logBeforeAdvice(JoinPoint joinPoint){

        log.info("--- aop ----" + joinPoint.getSignature() + "--" + Arrays.toString(joinPoint.getArgs()));
    }

    // after methods end
    @After("execution(public boolean com.practice.springbasic.springaop.TestAopClass.test(String))")
    public void logAfterAdvice(JoinPoint joinPoint){

        log.info("--- end ----");
    }

    // when method return
    @AfterReturning(pointcut = "execution(public boolean com.practice.springbasic.springaop.TestAopClass.test(String))", returning = "b")
    public void logAfterReturningAdvice(JoinPoint joinPoint, boolean b){

        log.info("--- return ----" + b);
    }

    // when method throw exception
    @AfterThrowing(pointcut = "execution(public boolean com.practice.springbasic.springaop.TestAopClass.test(String))", throwing = "customExp")
    public void logAfterThrowingExceptionAdvice(JoinPoint joinPoint, Exception customExp){

        log.error("--- exp ----" + customExp);
    }

    // everything (combination of before, after, returning and exception also)
    @Around("execution(public boolean com.practice.springbasic.springaop.TestAopClass.test(String))")
    public Object logAroundAdvice(ProceedingJoinPoint joinPoint)  {

        log.info("--- starting method using around ----" + joinPoint.getSignature());
        boolean b = false; // object will change according to return type
        try {
            // allowing method to be call
            b = (boolean) joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("If exception occur");
        }

        log.info("--- method ended using around ----");

        return b;
    }

}
