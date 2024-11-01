IOC -> giving control to spring to create object
Dependency injection -> Injecting an object is called DI.
 3 types -> constructor, setter, field injection(problem of mocking so not recommended)
# IOC 
`What it is:` An IoC container is a framework that manages the creation and lifecycle of objects in an application.

`How it works`: Instead of creating objects manually within the code, we let the IoC container handle the job
                of creating and configuring these objects. It decides when and how to create them, often based on 
                configurations or annotations. i.e. (@Service, @component, xml bean configuration).

`Benefit`: This setup reduces the need to manage object creation ourselves, making the code cleaner and more modular.
           The container does the "wiring" of objects, saving us from hard-coding dependencies.

# Dependency Injection
`What it is`: Dependency Injection is a technique that IoC containers use to provide objects with the dependencies
              they need.

`How it works`: Instead of each object creating its own dependencies, 
                the IoC container "injects" the required objects (dependencies) into it.

`Example:` If an object Car needs an Engine to function, 
           the IoC container will automatically supply the Engine to Car when creating it.

`Benefit`: DI makes code more flexible and easier to test. You can swap dependencies without changing the main code.
