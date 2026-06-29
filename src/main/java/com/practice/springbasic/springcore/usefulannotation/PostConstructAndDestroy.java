package com.practice.springbasic.springcore.usefulannotation;

public class PostConstructAndDestroy {

    /*
    * @PostConstruct: Annotate a method to be executed after the bean is fully constructed and dependencies are injected.
    *  It is used for initialization logic.
    * Example Usage: Initializing resources, setting up connections, etc.
    *
    * Bean Creation: Spring creates an instance of the bean.
    * Dependency Injection: Spring injects the dependencies into the bean.
    * Post-Construction: After the dependencies are injected and the bean is fully initialized,
    * [Spring calls the method annotated with @PostConstruct.]
    *
    * @PreDestroy: Annotate a method to be executed just before the bean is destroyed.
    * It is used for cleanup logic.Example Usage: Closing connections, releasing resources, etc.
    * */


/*    Spring beans go through several lifecycle phases:

    Instantiation: The bean is created.
    Dependency Injection: Spring injects dependencies into the bean.
    Post-processing: Spring applies any post-processing logic, such as applying aspects.
            Initialization: If there are initialization methods (e.g., @PostConstruct), they are called.
    Destruction: When the Spring container is shut down or when the bean is explicitly removed, the bean is destroyed.*/
}
