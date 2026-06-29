package com.practice.springbasic.springcore.ioc_and_di.types_of_di;

public class AutowiredInjection { // Spring use Java reflection

    /*
       You can also apply the annotation to methods with arbitrary names and multiple arguments, as the following example

           public class MovieService {
    	    private MovieCatalog movieCatalog;
            private CustomerPreferenceDao customerPreferenceDao;

            @Autowired
            public void prepare(MovieCatalog movieCatalog, CustomerPreferenceDao customerPreferenceDao) {
                this.movieCatalog = movieCatalog;
                this.customerPreferenceDao = customerPreferenceDao;
            }
            }

            Spring automatically calls the prepare method and injects dependencies when creating the MovieService bean.
            If you have both a constructor and a method annotated with @Autowired, Spring will:
            Call the constructor first to create the bean and inject dependencies.
            Then call the @Autowired method (prepare) after the object is created.

            If there are two methods with @Autowired, Spring will call both methods, injecting dependencies where required.
            Class using Movie Service
            @Component
            public class MovieApplication {
                private final MovieService movieService;

                @Autowired
                public MovieApplication(MovieService movieService) {
                    this.movieService = movieService;
                }
            }




/////    Qualifier

            @Component("horrorMovieCatalog")    // bean id
            public class MyBeanA{

            }


            // Constructor of MyClient Class
            public MyClient(@Qualifier("myBeanA") MyService myService) {
                this.myService = myService;
            }

             Alternative of Qualifier
             Use @Primary when you want a default bean for all injections.

             1. @Component <--- Application based configuration
                @Primary  // ServiceA is the default bean
                public class ServiceA implements MyService { }

             2. 	@Bean

                    @Primary
                    public MovieCatalog firstMovieCatalog() { ... }

    * */
}
