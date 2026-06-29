                            Your Bussiness Object Pojo
                                |
                                |
 Configuration MetaData ---> [Spring Container]  ===> Ready to use
 [Configured Objects]

Spring IoC container consumes a form of configuration metadata. This configuration metadata represents how you, 
as an application developer, tell the Spring container to instantiate, configure, and assemble the components 
in your application.

These days, many developers choose Java-based configuration for their Spring applications:
`Annotation-based configuration`: define beans using annotation-based configuration metadata on your application’s 
component classes.
`Java-based configuration`: define beans external to your application classes by using Java-based configuration classes. 
To use these features, see the @Configuration, @Bean, @Import, and @DependsOn annotations.

###
`The classpath is a parameter that tells the (JVM) and the Java compiler (javac) 
where to look for class files and resources when running or compiling a Java program.`
###

[
   During the application startup, the Spring container:
   Scans the configuration files (XML or Java-based) and annotated classes.
   Creates and initializes the beans as defined.
   Injects dependencies into the beans using constructor injection, setter injection, or field injection. 
   In Spring, the default scope for beans is singleton. 
   This means that the Spring container creates only one instance of the bean per Spring container, 
   and this single instance is shared throughout the application.
]
`This could lead issue while running multiple thread concurrently so we need to follow state less and thread safe behaviour`
example ->
@Service
public class CounterService {

    private int counter = 0; // state behaviour (not thread safe)

    public void incrementCounter() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
[We can use Atomic to make it thread safe]

# Singleton scope is the best 
No — singleton scope itself does not slow down concurrent requests. Here's why:
- Singleton beans are shared, but they don’t block threads unless you write code that introduces blocking or shared mutable state.
- Spring Boot handles each HTTP request in a separate thread (from a thread pool), regardless of bean scope.
- Singleton beans are thread-safe as long as they are stateless — meaning they don’t store request-specific data in instance variables
- Performace is Better (less GC, fewer objects)
