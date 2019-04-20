## Boundaries
### GoldenRules
1. **Using third party code** 
    - Unlike our own classes(which has only relevant methods for the context)
third party boundary interfaces have lot of generic methods. So it is a good practice to not return
raw boundary interfaces.
    - Take the example of java.util.Map . This has lot of methods which we may not want to expose to
    the consumer. If we return map, this could be manipulated with the methods like .clear()
    - So it is a good practice to wrap such boundary interfaces when it needs to be passed around 
    in the system.
    - Especially in public APIs avoid receiving and returning raw boundary interfaces 
    like maps
