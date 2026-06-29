Dependency injection -> Injecting an object is called DI.
 3 types -> constructor, setter, field injection(problem of mocking so not recommended)

# IOC -> giving control to spring to create object (inversion of control)
`Inversion of Control (IoC)` is a design principle used in object-oriented programming where the control of object 
creation and dependency management is transferred from the application code to an external framework or container. 
This reduces the complexity of managing dependencies manually and allows for more modular and flexible code.

[IoC (Inversion of Control) is a design principle, not a container itself.]

The Spring Container (like BeanFactory or ApplicationContext) is the actual implementation 
of that IoC principle — it creates, configures, and manages beans according to the IoC idea

In Spring framework there are mainly two types of Spring Container which are listed below:

1. BeanFactory: BeanFactory is the simplest container and is used to create and manage beans. 
It is a basic container that initializes beans lazily (i.e., only when they are needed). 
It is typically used for lightweight applications where the overhead of ApplicationContext is not required.

[Example]:
Resource resource = new ClassPathResource("beans.xml");
BeanFactory factory = new XmlBeanFactory(resource);
MyBean obj = (MyBean) factory.getBean("myBean");

[Explanation]:
ClassPathResource loads the beans.xml file from the classpath.
XmlBeanFactory creates a basic IoC container using that XML (loads beans lazily).
getBean("myBean") retrieves and creates the bean with ID myBean.
Note: This will create a Car bean inside the IoC container, which will be initialized when requested.

2. Application Context: ApplicationContext is an advanced container that extends BeanFactory and provides additional 
features like internationalization support, event propagation and AOP (Aspect-Oriented Programming) support. 
The ApplicationContext is preferred in most Spring applications because of its enhanced features.

[Example]:
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
MyBean obj = (MyBean) context.getBean("myBean");

# Dependency Injection
`What it is`: Dependency Injection is a technique that Spring containers use to provide objects with the dependencies
              they need. Instead of each object creating its own dependencies, the Spring container "injects" 
              the required objects (dependencies) into it. If an object Car needs an Engine to function, 
              the Spring container will automatically supply the Engine to Car when creating it.

`Benefit`: DI makes code more flexible and easier to test. You can swap dependencies without changing the main code.

[Here objects/class define their dependencies only through constructor arguments, arguments to a factory method, 
or properties that are set on the object instance after it is constructed or returned from a factory method. 
The IoC container then injects those dependencies when it creates the bean. 
This process is fundamentally the inverse (hence the name, Inversion of Control)]

`In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC container 
are called beans. `

