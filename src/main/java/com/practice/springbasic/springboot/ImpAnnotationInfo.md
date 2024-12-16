# @Value Annotation
The @Value annotation allows you to inject values from application.properties, application.yml, 
or environment variables into Spring-managed beans.

For Spring to manage a bean, the class must be annotated with @Component, @Service, @Repository, or another stereotype 
annotation. This tells Spring to detect the class during component scanning and register it as a bean in the 
application context.
When the class is a Spring-managed bean, Spring can handle the injection of values into fields annotated with @Value.
If the class is not a Spring-managed bean, Spring will not be able to process the @Value annotation, 
and the injection will not occur.

# @RequestBody
Internally use Jackson (or another configured JSON library) to handle the conversion of JSON data to Java objects and vice versa.
Spring Boot, by default, uses MappingJackson2HttpMessageConverter to convert the JSON string to a Java object.
Jackson is the default JSON library used by Spring Boot for this purpose.
