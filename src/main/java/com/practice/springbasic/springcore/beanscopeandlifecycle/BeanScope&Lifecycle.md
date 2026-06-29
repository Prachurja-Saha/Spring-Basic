# Spring creates beans (based on provided configuration), ways of creating bean is called bean scope
Types of bean scopes or ways of creating bean

1. Singleton scope (default scope) - single instances (we can check by getBean() and printing hashcode of objects)
2. Prototype scope - any number of instances [creation of a new bean instance every time a request is made]
3. Request: This scope is specific to web applications. A new bean instance is created for each HTTP request. 
   This is useful for beans that need to be short-lived and specific to a single HTTP request.
4. Session: Also specific to web applications, a new bean instance is created for each HTTP session. 
   This allows you to maintain user-specific state across multiple requests within a single session.
5. Application: This scope is related to web applications as well. A single bean instance is created for the lifecycle 
   of a ServletContext. This is similar to Singleton scope but specific to a web application's context.
6. WebSocket: This scope creates a new bean instance for each WebSocket session.

TODO: Know more about Request, session, application, websocket scope

# Prototype example:
@Component
@Scope("prototype") ---> scope
public class MyPrototypeBean {

public MyPrototypeBean() {   print("MyPrototypeBean instance created."); }
public void doSomething() { System.out.println("Doing something..."); }

}

@Service
public class MyService {
@Autowired
private ApplicationContext applicationContext;

    public void usePrototypeBean() {
        MyPrototypeBean prototypeBean = applicationContext.getBean(MyPrototypeBean.class);
        prototypeBean.doSomething();
    }
}
`If MyService(singleton bean) is dependent on MyPrototypeBean via construtor injection than we have to use 
  Provider from javax.inject to ensure a new instance of MyPrototypeBean is created every time it's needed`


# Request @Scope("request")
Context: Specific to web applications.
Instance Creation: A new bean instance is created for each HTTP request.
Usage: Use when the bean should only last for the duration of a single HTTP request.
Example: Controllers or services that handle web request processing, where each request should be handled independently.
Resource Management: Beans are short-lived and only exist for the duration of the HTTP request, conserving memory.
- Scopes allow you to manage the lifecycle of beans. For example, a request-scoped bean exists only for the duration of 
an HTTP request, ensuring isolation and preventing shared state

# Request @Scope("session")



# Spring beans go through several lifecycle phases:
    Instantiation: The bean is created.
    Dependency Injection: Spring injects dependencies into the bean.
    Post-processing: Spring applies any post-processing logic, such as applying aspects.
            Initialization: If there are initialization methods (e.g., @PostConstruct), they are called.
    Destruction: When the Spring container is shut down or when the bean is explicitly removed, the bean is destroyed.