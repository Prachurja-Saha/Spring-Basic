
# IOC is just concept / design pattern
everything is done by spring container
spring container used IOC concept -> maintain object/bean lifecycle
and DI is the process by which spring container inject bean/ object to the particular class


IoC (Inversion of Control) is indeed just a concept or design principle. 
It's about shifting control over creating and managing dependencies to an external entity, 
not done by the objects themselves.

Spring Container is what actually implements IoC in the Spring Framework. 
It’s the part of Spring that handles creating, managing, and injecting beans (objects) based on configurations.

Dependency Injection (DI) is the process used by the Spring Container to apply IoC, 
injecting dependencies into objects instead of the objects creating their own dependencies.

# Spring Container uses the IoC principle and implements it through DI to handle object management. 