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