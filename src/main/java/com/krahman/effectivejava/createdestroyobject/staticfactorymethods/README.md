### **Item 1:** Consider static factory methods instead of constructors

1. This is not the same as the Factory Method Pattern
2. It can be there instead or in addition to constructors

**Advantages**
1. **Can have a meaningful name.** This will help in readability in sitiation where we need two constructors with same 
signature. like Book(int pages, String Author ) and Book(int volumes, String Author)
2. **No need to create a new object each time invoked:** Perfect example is immutable classes enforcing 
preconstructed instances. This further leads to singleton and non instantiable classes. 
3. **Unlike constructors, return type can be any subtype of return type:** This leads to "interface-base frameworks"
where the actual implementation can be hidden from the clienty. java.util.Collections is one good example. We always 
hold the interface reference, while having the collections static methods can create instances of specific  
implementations
4. **Class of the returned object can vary from call to call as a function of the input parameters:**
    For instance we can return an object for small size vs big size.
5. **Class of the returned object need not exist when the class containing the method is written:**
    This is the basis of Service provider framework [Service provider framework pattern] . JDBC APIs are a good example 
    of this pattern. 
        - Service Interface - 
        - Provider registration API - for the providers to register the implementation
        - Service Access API - allow clients to specify their criteria for choosing the implementation
**Limitations**
1. Classes without protected or public constructors cannot be subclasses - this is infact good as it encourges 
compositions over inheritance.
2. Documentation - hard for the programmers to find
    This can be overcome by following stand naming conventions:
        - from
        - of
        - valueOf
        - instance or getInstance
        - create or newInstance
        - get*Type* like Files.getFileStore()
        - new*Type*  like Files.newBufferReader()
        - type  like Collections.list()
        
    ## Before writing a public constructor, its better to consider static factory methods