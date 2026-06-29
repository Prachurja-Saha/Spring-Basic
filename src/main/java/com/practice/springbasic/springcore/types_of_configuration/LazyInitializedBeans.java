package com.practice.springbasic.springcore.types_of_configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

// By default bean are singleton
@Configuration
public class LazyInitializedBeans {

    // By default, ApplicationContext/Spring container implementations eagerly create and configure all singleton
    // beans as part of the initialization process.

    // Lazy loading : A lazy-initialized bean tells the IoC container to create a bean instance when it is first requested, rather than at startup.
    @Bean
    @Lazy
    LazyInitializedBeans lazy() {
        return new LazyInitializedBeans();
    }
    /*
    * A lazy-initialized bean tells the IoC container to create a bean instance when it is first requested,
    * rather than at startup.
    *
    * However, when a lazy-initialized bean is a dependency of a singleton bean that is not lazy-initialized,
    * the ApplicationContext creates the lazy-initialized bean at startup, because it must satisfy the singleton’s
    * dependencies. The lazy-initialized bean is injected into a singleton bean elsewhere that is not lazy-initialized.
    * */
}
