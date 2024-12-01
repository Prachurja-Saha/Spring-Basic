package com.practice.springbasic.springcore;

import com.practice.springbasic.SpringBasicApplication;
import com.practice.springbasic.springcore.types_of_configuration.MyClass;
import com.practice.springbasic.springcore.types_of_configuration.XMLTest;
import com.practice.springbasic.springcore.types_of_di.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/* In the context of the Spring Framework, a bean refers to an object*/
/* Bean/IOC Container 2 types: 1.BeanFactory(basic)  2.ApplicationContext(Advance) */
@Component
public class TestIOCMain {

    public void build(){
        System.out.println(" Project is running ...");
    }
    public static void main(String[] args) {

        // ---------- Test IOC and DI --------------
        // This will Run the IOC container -> SpringApplication.run(SpringBasicApplication.class, args)
        /*
            IOC container itself is object so
        * In Spring, the IoC container has two main types:
        * 1. Bean Factory -> Basic IoC container in Spring
        * 2. Application Context -> advanced & widely used IoC container in Spring, & it builds on top of BeanFactory.
        *                           provides all the functionalities of BeanFactory.
        */

        ApplicationContext context;

        context = SpringApplication.run(SpringBasicApplication.class, args); // Returns Obj Of IOC High Level

        // Retrieving the object from IOC  assuming the Object is present in IOC
        // Here Bean is equivalent to object
        TestIOCMain testIOCMain = context.getBean(TestIOCMain.class);
        // we have to configure the class either by annotation, Xml configuration etc. to tell IOC to create object
        // or bean for this particular class. here we need to configure TestIoc class if not the object will not
        // present in IOC and will throw exception with message -> No qualifying Bean available.

        testIOCMain.build();

        /*
         Its working b/c in another main There is mention @SpringBootApplication which contains @ComponentScan
         @EnableAutoConfiguration , @Configuration
         b/c this class is in same package application will still run
         */

        // ---- Types of DI Test -----
        Test test = context.getBean(Test.class);
        test.print();

        //-------- Types of configuration-----------

        // 1. XML Configuration
        ApplicationContext xmlTestContext
                = new ClassPathXmlApplicationContext("bean.xml"); // File name
        XMLTest xmlTest = xmlTestContext.getBean(XMLTest.class);
        xmlTest.test();
        System.out.println(xmlTest.getSomeProperty());

        // 2. Bean Annotation
        MyClass beanTest = context.getBean(MyClass.class);
        beanTest.test();





    }

    //TODO: What is command liner

}
