## Systems
### Golden Rules
1. This section is all about the holistic system design within the code
2. **Separate Constructing a System from using it**
        - _Software systems should separate the startup process, when the application objects are constructed and the 
        dependency objects are "wired" together, from the run time lgic that takes over after startup_
        - **Separation of Main** is one way to separate construction from its use - by moving the construction logic to 
        the main and design the rest of the systems assuming all the objects have been constructed.
        - **Factories** is other way where we can use abstract factory pattern to give application control of when to
        build a dependency.
        - **Dependency Injection** - the application of Inversion of Control(IoC) to dependency management.This further
        ensures SRP. JNDI is partial DI - as (MyObject)jndiContact.lookup("MyObject"); still directly resolves it 
        dependency. A true DI would not even ask for dependency resolution - spring is the best example.
 3. **Scaling up**
        - In order to build a big building we might need to do Big Design Up Front. But software systems do not need 
        BDUF. Rather if we follow **seperation of concerns** then we can start small and progressively build big.
        - **Cross cutting concerns** Persistence, Security, Transactions are some examples of cross cutting concerns 
        which should be separated from application code. 
        - **Pure Java Proxies & bute manipulation libraries** java proxies are less known way of doing separation of concerns. 
        https://dzone.com/articles/power-proxies-java Java proxies only implement interfaces. For classes, we need a 
        byte-manipulation libraries like Javaassist, CGLIB etc
        - **Pure Java AOP frameworks** The pure java proxies are used internally in several framwworks which avoids
        boiler plate proxy code in application code. For instance, in Spring we write POJOs which are purely focussed on
        domain which are then annotated to/configures to wire with the cross cutting concerns.
        Persistence in Spring is a good example for this. 
        -**AspectJ aspects** this is a specific language, an extension of java that provides support for aspects as 
        modularity constructs. While Spring AOP implementation of pure java proxies cover 80 to 90% of requirements,
        aspectJ has its place for specfic requirements.
        
 This lifts my understanding of Spring :
 1. Separate constructing a system from using it - Dependency injection
 2. Separation of cross cutting concerns - through pure java proxies. Spring internally implements pure java proxies
    to provide configurable/Annotatable cross cutting features.