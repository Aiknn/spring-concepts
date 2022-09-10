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