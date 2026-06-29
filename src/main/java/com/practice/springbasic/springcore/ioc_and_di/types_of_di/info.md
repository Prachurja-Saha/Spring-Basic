`Constructor-based or setter-based DI?`
🧱 Use Constructor Injection for required dependencies.
   1. Ensures immutability and fully initialized objects.
   2. Prevents null dependencies.
   3. If too many constructor arguments → class likely has too many responsibilities (refactor needed).

⚙️ Use Setter Injection for optional dependencies.
   1. Allows reconfiguration later (e.g., JMX).
   2. Should provide default values if not injected.

💡 Rule of thumb:
   1. Constructor → mandatory dependencies 
   2. Setter → optional dependencies


`Circular dependencies`
If you use predominantly constructor injection, it is possible to create an unresolvable circular dependency scenario.
For example: Class A requires an instance of class B through constructor injection, and class B requires an 
instance of class A through constructor injection. If you configure beans for classes A and B to be injected into 
each other, the Spring IoC container detects this circular reference at runtime, 
and throws a BeanCurrentlyInCreationException.

One possible solution is to edit the source code of some classes to be configured by setters rather than constructors. 
Alternatively, avoid constructor injection and use setter injection only. In other words, [although it is not 
recommended, you can configure circular dependencies with setter injection. 
because: It hides design flaws (tight coupling) and Makes the code harder to maintain or test.]

example how setter injection resolve circular dependency issue
    class A {
        private B b;
        public void setB(B b) { this.b = b; }
    }
    
    class B {
        private A a;
        public void setA(A a) { this.a = a; }
    }

Now Spring can: Create bean A (empty), Create bean B (empty), Then inject B into A and A into B afterward ✅
So the circular reference is resolved because Spring can partially build objects and wire them later,
which is impossible with constructor injection (where dependencies are required immediately).

# Other way to handle circular dependency (All approaches are better than setter)
1.  Refactor code -> Best approach and recommended
2.  interface/ event decoupling (Best/Clean design) [Instead of two classes directly depending on each other, introduce:
    An interface or service layer between them. ]
    interface BService { void doSomething(); }

    @Component
    class B implements BService {
    @Autowired
    private A a;
    
        public void doSomething() {
            System.out.println("In B");
        }
    }
    
    @Component
    class A {
    private final BService bService;
    
        @Autowired
        public A(BService bService) {
            this.bService = bService;
        }
    }

3.  @Lazy -> Effective, Temporary fix [@Lazy tells Spring to inject a proxy instead of immediately creating the other bean].
    @Component
    public class A {
      @Autowired
      private @Lazy B b;
    }





[DI PROS and CONS]
Constructor Injection
Pros:
Immutability: Since dependencies are provided at the time of object creation, the fields can be marked as final, making the object immutable.
Mandatory Dependencies: It ensures that all mandatory dependencies are provided, preventing the creation of objects in an invalid state.
Testing: It makes the objects easier to test by allowing dependencies to be passed in as mocks.

Cons:
Complexity: For classes with many dependencies, constructors can become unwieldy and hard to manage.
Readability: If there are multiple overloaded constructors, it can be challenging to understand which constructor to use.
Circular Dependencies: Constructor injection can make circular dependencies more difficult to resolve.

Setter Injection
Pros:
Readability: It makes the configuration more readable, especially for classes with many dependencies.
Optional Dependencies: It allows optional dependencies to be set after object creation, providing more flexibility.
Configuration: Dependencies can be changed or configured after the object has been created, which can be useful in certain scenarios.

Cons:
Partial Initialization: The object can be in an invalid state if all the dependencies are not set, which might lead to runtime errors.
Immutability: It does not support immutable objects, as the dependencies can be changed after object creation.
Testing: It can make testing more difficult, as dependencies need to be set separately from object creation.

Field Injection
Pros:
Simplicity: It is the simplest form of DI, requiring no explicit constructor or setter methods.
Readability: The code is more concise and easier to read, as there are no additional methods.
Ease of Use: It's convenient for quick prototyping and development.

Cons:
Testing: It makes testing more difficult, as reflection is required to set the dependencies, making unit tests harder to write and maintain.
Immutability: Field injection does not support immutable objects.
Visibility: It hides the dependencies from the class's public API, making it less clear what the class's dependencies are.
Framework Dependence: It tightly couples the class to the DI framework (Spring), making it harder to use the class outside of the Spring context.