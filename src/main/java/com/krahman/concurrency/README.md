## Concurrency
### Golden Rules
1. Myths about concurrency
    - It always improves performance
    - Design doesnt change when writing concurrent program
    - Understanding concurrency issues is not important when working with a container such as a Web or EJB container
2. Some facts about concurrency code:
    - Concurrency involves some overhead - both in performance and code
    - Correct concurrency is complex
    - Concurrency bugs are not usually repeatable
    - Concurrency often requires fundamental changes in design strategy
 3. Concurrency Defense principles
    - SRP: Keep your concurrency code separate from other code 
    - Corollary: Limit the scope of the data - Severely limit the access of any data that may be shared. 
    - Corollary: Use copies of data - Avoid sharing the data, rather share the copies and synchronize later
    - Corollary: Threads should be as independent as possible - if that means data partitioning (for the purpose of 
    exclusive set of threads to work on) then go for it.
 4. Know your library:
    - Understand the concurrency libraries in your programming language
    - For Java, understand the features like
        - Usage of concurrent data structures
        - Executor frameworks
        - Using non blocking solutions
        - Recognizing the non thread safe libraries
     - Get familiar with Java's concurrency package , concepts like reentrant locks etc
 5. Know your execution model:
    Terminologies:
        - Bound resources - fixed number of threads for DB connection
        - Mutual Exclusion
        - Starvation - Preventing a thread or group to running for long time
        - Deadlock
        - Livelock
     Execution Models:
        - Producer-Consumer: Queue between the producer and consumer is a bound resource
        - Reader-Writers: Balancing between blocking readers and writers
        - Dining Philosophers - Threads competing for a resource
 6. Beware Dependencies between Synchronized Methods
    - Avoid using more than one method in shared object
 7. Keep synchronized methods as small as possible
 8. Testing Threaded Code:
    - Get the non threaded code working first
    - Make your threaded code pluggable
        One threaded, multoi threaded, able to vary during execution
        Threaded code interacts with something that can be both real and test double
        Execute with test double that scales along
    - Make your threaded code tunable
    - Run with more threads than processors
    - Run on different platforms
    - Instrument your code to try and force failures
        Adding randon object.wait(), object.yield(), object.sleep(), abject.priority() 
            - Hand coded - trickey
            - Automated (AOP - CGLIB, ASM) - good choice
    - Do not ignore system failures as one-off
       
    
        
          