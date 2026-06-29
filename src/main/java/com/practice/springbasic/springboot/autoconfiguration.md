#  Spring Boot Auto-Configuration
One of the powerful features of Spring Boot is its auto-configuration capability. Here’s how it works:

1. Spring Boot Starters
Spring Boot provides various starter dependencies that automatically configure your application based on the 
libraries present in the classpath. 
For example, if you add spring-boot-starter-web, Spring Boot will auto-configure a web server like Tomcat.
[In Spring Boot, when you add a starter dependency (like spring-boot-starter-web), it brings in a group of related 
libraries (e.g., Spring MVC, Jackson, etc.). Spring Boot then uses auto-configuration to automatically configure 
your application based on the classes found on the classpath.]
   Classpath: It refers to all the .jar files and classes available at runtime. 
   Spring Boot checks the classpath to detect which libraries are present.

2. Auto-Configuration Classes
Spring Boot includes several auto-configuration classes that contain conditional logic to 
configure beans based on the presence of certain classes or properties. 
These classes are located in the org.springframework.boot.autoconfigure package.

3. Application Context
When the application starts, Spring Boot scans the classpath and detects the configurations 
specified in application.properties and the auto-configuration classes. It then sets up the application context accordingly.

4. Overriding Default Configurations
You can override default auto-configurations by defining properties in the application.
properties file or by creating custom configuration classes with the @Configuration annotation.

5. Profiles
Spring Boot also supports profiles, which allow you to define different sets of configurations 
for different environments (e.g., development, testing, production). 
You can create application-dev.properties, application-test.properties, etc., and specify the active profile 
using the spring.profiles.active property.


[example of autoconfiguration]
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

→ Maven downloads all related JARs (JPA, Hibernate, etc.)
    A .jar is just a compressed package of compiled Java classes + metadata + resources.
    Maven downloads these JARs (and their transitive dependencies) from online repositories (like Maven Central) 
    and stores them in your local .m2 folder.
→ Spring Boot sees JPA classes → auto-configures a database connection, EntityManager, etc.
→ You just add properties in application.properties, and it works (for spring jpa)


Example 2:
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>
If you add spring-boot-starter-web, Spring Boot detects you want to run a web app → automatically configures Tomcat,
DispatcherServlet, and Spring MVC beans.
You don’t have to manually create those beans or XML configs.