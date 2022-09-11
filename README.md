# Spring Concepts

### di-without-spring
* In this part we used Dependency Injection without Spring and its annotations.
* We used 3 types of DI. But constructor injection is mostly preferred.

### di-spring general
* We put @Controller annotation (it extends from @Component), so Spring retrieve bean. 
* The beans name equals annotated class name (MyController) with first small letter (myController). 
* As you can see in this example, main class could create object from MyController class without using 'new'.
* We put @Autowired annotation to injected class, so Spring will inject it when created object from main class.
* We put @Service annotation to implemented class (from interface), so Spring know which implementation of interface to use.

### qualifiers
* Used when there is 2 or more services, so Spring will know which service to inject (bt default we inject interface)
* All interface implementations should have @service annotation
* Property injected controller class should have @Qualifier("propertyGreetingService") and @Autowired above the injected interface.
* Constructor injected controller class should have @Qualifier("constructorGreetingService") in constructor parameters before the interface name. And NO @Autowired.
* Setter injected controller class should have @Qualifier("setterGreetingService") and @Autowired above the setter.

### primary bean
* If there are 2 or more services to be injected, then primary bean will have higher priority to be injected.
* To create primary bean you need put @Primary and @Service above the implementation of interface.
* If Constructor injected controller have @Qualifier + @Autowired it will use service with @Primary annotation.
* If Constructor injected controller class have only @Qualifier annotation it will use own service.

### spring profiles
* Help segregate your application configuration, and makes them available only in certain environments.
* Lets you control or point out needed service to be injected (if several implementations of interface) from application.properties.
* All needed services (interface implementations) should be named, e.g. @Service("i18nService").
* Constructor injected controller should have qualifier named the same as services above, e.g. @Qualifier("i18nService").
* All needed services should have profile names above the class, e.g. @Profile("ES"). And each service should have other namings.
* Control or choose service by entering its profile name in application.properties file, e.g. spring.profiles.active=ES

### default profiles
* You can set default property name in service like - @Profile({"ES", "default"})
* If application.properties file does not specify spring.profiles.active, then default service will bw used.
* If application.properties file does specify spring.profiles.active, then default profile will be ignored.

### component scan
* By default, Spring searches beans in package (and its sub packages) where Application (main) file is located.
* If you want Spring scan other packages you need add @ComponentScan(basePackages = {"com.guru.spring", "com.guru.pet"}) on Application class.

### Spring configuration options
* XML Based - legacy, but supported
* Annotation based configuration - use Component Scan and Stereotypes (@Controller, @Service, @Component, @Repository).
* Java based configuration - use @Configuration and @Beans

### refactoring Annotation configuration to Java configuration 
* Getting rid of component scan annotation (in huge projects it might be problem to have too much to scan).
* Delete @Service annotation from service class.
* Create configuration class and annotate it with @Configuration
* Create constructor of service (without declaring it) and annotate it with @Bean
