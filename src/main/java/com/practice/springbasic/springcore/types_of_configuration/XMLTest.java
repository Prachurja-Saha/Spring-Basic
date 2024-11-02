package com.practice.springbasic.springcore.types_of_configuration;

/* This XML Based Configuration file -> bean.xml*/
public class XMLTest {

    String someProperty;

    public void test(){
        System.out.println("Test XML configuration");
    }

    public void setSomeProperty(String someProperty) {
        this.someProperty = someProperty;
    }

    // Optional: Getter for accessing the property elsewhere
    public String getSomeProperty() {
        return someProperty;
    }

}
