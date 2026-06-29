package com.practice.springbasic.springcore.usefulannotation;

public class Value {

    /*
    * @Value is typically used to inject externalized properties
    *
    *   @Configuration
        @PropertySource("classpath:application.properties") --> Used for injecting all properties
        public class AppConfig { }
    * */
    // @PropertySource tells Spring to look for the application.properties file in the classpath and load the properties
    // defined in it.
    // VIMP : You typically don't need to use @PropertySource("classpath:application.properties").
    // Spring Boot automatically loads properties from application.properties or application.yml in the classpath.
    // This is one of the conveniences provided by Spring Boot's auto-configurtion
    /*
        another example  ->

            @Component
            public class MyComponent {
                @Value("${my.custom.property}")
                private String myProperty;

                public void printProperty() {
                    System.out.println(myProperty);
                }
            }

            IMP NOTES
            No-Arg Constructor: Since you didn't define any constructors in MyComponent, the Java compiler automatically
            provides a default no-argument constructor.

            Private Field Injection: The @Value annotation is used to inject values into private fields.
            Spring can inject values into private fields through reflection.
            It doesn't matter whether the field is private because Spring has access to the underlying structure of the class.

            Bean Creation and Value Injection: During the bean creation process, the Spring container:
            Creates an instance of MyComponent using the no-argument constructor.
            Uses reflection to inject the value of my.custom.property into the myProperty field, even though it's private.

    */

    // Alternative OF @Value
    //You can also use @ConfigurationProperties to bind properties to a POJO.
    /*
     i.e. application.properties -> app.name=MySpringBootApp  app.version=2.0.0
        @Component
        @ConfigurationProperties(prefix = "app")
        @Data
        public class AppConfigProperties {
            private String name;
            private String version;
         }

     if app.prop app.abc.version=2.0.0 app.abc.name=MyApp
     than need to create nested class
        @Component
        @ConfigurationProperties(prefix = "app")
        public class AppConfigProperties {
            private Abc abc;

            public static class Abc {
                private String version;
                private String name;

    */
}
