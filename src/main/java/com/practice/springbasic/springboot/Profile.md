# This is a Spring concept
In Spring, you can define profiles in configuration files like application.properties or 
application.yml, or by using annotations in the code.
Profiles let you activate specific beans or configurations only when a particular profile is active.

# You can also use the @Profile annotation in code to mark beans or configuration classes that 
# should only be loaded for a specific profile.
[ 
    @Configuration
    @Profile("dev")
    public class DevConfiguration {
    // Beans or settings specific to dev profile
    }    
]


In Spring Boot, profiling refers to the use of profiles to separate parts of your application configuration. 
This allows you to easily switch between different environments and configurations 
(like development, testing, production) without changing your main codebase.

# Application.properties
application.properties file helps configure a Spring Boot application. 
It is the main configuration file used to define application-level settings and behaviors without changing the source code.

What it does:
`Centralized Configuration:` You can define database URLs, server ports, logging levels, feature flags, 
custom properties (app.prop, etc.), and more.
`Environment-Specific Settings:` Spring Boot allows you to have different versions like application-dev.properties, 
application-prod.properties for different environments.
`Bean Customization:` Custom properties in application.properties can be injected into Spring Beans using 
@Value or @ConfigurationProperties, enabling dynamic behavior based on the environment or external config.