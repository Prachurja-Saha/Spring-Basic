
### 1. Auto-Configuration vs. Manual Configuration
Spring Boot automatically configures many common components -> using application.properties/yaml
(e.g., database connections, embedded server setup), saving time and reducing boilerplate code.

[In traditional Spring (without Spring Boot), there isn’t a built-in application.properties file. Instead, 
configuration is generally done through XML or Java-based configuration classes.]

you can add custom properties files in Spring (like app.properties), but you’ll need additional 
steps to load these properties. Here’s how it works in Spring:
`Example -> craeting custom app.properties file in spring`
[To load these properties in Spring, have to use @PropertySource/@Value to inject the properties where needed.]
# app.properties
db.url=jdbc:mysql://localhost:3306/mydb
db.username=user
db.password=password

# With plain Spring, you’d need to manually set up a DataSource
@Configuration
@PropertySource("classpath:app.properties")
public class AppConfig {

    @Value("${db.url}")
    private String dbUrl;
    
    @Value("${db.username}")
    private String dbUsername;
    
    @Value("${db.password}")
    private String dbPassword;

    // Method to create DataSource using the properties
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }
}

# Spring Boot uses application.properties or application.yml by convention, 
# so you don’t need @PropertySource or @Value annotations for common configurations.
# Properties like database settings, server ports, or logging can be set directly in application.properties,
# and Spring Boot’s Auto-configuration picks them up automatically.


### 2. Embedded Server 
`Spring does not have embedded server`
To run a web application, you’d typically package it as a WAR file and deploy it to an external server 
(e.g., Tomcat or Jetty).
`spring boot has embedded server` easy for deployment

### 3. Starter Dependencies for Simplified Dependency Management
`spring-boot-starter-web`: includes all the dependencies for a web application, like Spring MVC, 
                           embedded Tomcat, Jackson, etc.
`spring-boot-starter-data-jpa`: it pulls in JPA, Hibernate, and related dependencies.

### 4. CommandLineRunner and ApplicationRunner for Quick Testing

### 5. Simplified Environment-Specific Configuration i.e application-dev.properties

### 6. DevTools for Development Convenience

### 7. Spring Boot Actuator for Production-Ready Monitoring and Metrics





