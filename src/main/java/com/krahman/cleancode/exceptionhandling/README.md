## Exception Handling
### Golden Rules
1. **Use Exceptions rather than error codes** : This makes sure that error handling code is 
separated from functional code.
2. **Write try-catch-finally first** Try block is essentially like a transaction boundary. So by 
defining exceptions first, you could focus on the transaction scope of that project. In other words
first write the exception scenario unit test cases.
3. **Use unchecked exceptions** 
    - There has been a lot of dicussion on usage of checked exceptions.
    - The price of checked exception is Open/Close principle. 
    - Any low level classes change in the checked
      exception will force change in the all the classes above it until a catch is found. 
    - This also breaks encapsulation as the internal exception details are know to a distant class
     which handles errors.
    - Checked exceptions are useful when we write critical library. But in general application
      development, the cost over weigh the benefit.
4. **Provide context with exception** provide enough information with the exception
5. **Define Exception classes in terms of caller's need**
    - Defining standard set of exceptions for a wider/generic users is often found in 3rd party APIs
    - It is a good practice to wrap third party apis to offer useful exceptions for the context.
    - Wrapping of 3rd party apis, also helps in decoupling specifics of the apis from application 
    code.
    - In a regular application code, often a single exception class is enough. Only in cases where
    one exception is handled and other is let pass through, we may need more than one.
6. **Define the normal flow** avoid having logic within exception block, rather create a special 
case handling class to minimize the exception handling responsibility of the caller
7. **Dont return null** never return null from a method, this will cause potential issues. Whenever 
there is a scenario to return null, use special case objects. For instance, instead of returning 
null, return a empty list(where the return type is a list)
8. **Dont pass null** Once a accidentally null is passed to a method, there is a whole lot of 
possibility of something going wrong. 
