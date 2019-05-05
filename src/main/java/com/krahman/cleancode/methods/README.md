## Methods
### golden rules
1. Small. Methods need to be small. First and far most important rule.
    - If, else, while Blocks should be just one line long
    - The indent level of function should not be more than one
    - Methods should do just one thing. 
    - One of the easy ways to identify if a method is doing more than one thing is to look for 
    sections within the method.
2. One level abstraction per function
    - We need to make sure that the statements within the function are all at the same level of 
    abstraction
    - The stepdown rule - Methods shall follow a abstraction layer
3.  Switch Statements usually make the methods larger, violate open closed principle
    - The best thing to do with switch statement is to bury it under a factory method where we
     create the polymorphic objects.
4. Function Arguments
    - Ideal number of arguments - 0 
      With more arguments writing test cases becomes difficult.
    - Passing a boolean into a function is a terrible practice
        - It does more than one thing true/false. render(true) could have been modelled as 
        renderForSuite() and renderForTest()
        - readability goes for a toss in the invocation part function1(true)
    - Two arguments should be avoided but there would be situations where we cant avoid or it is 
    the required - point(0,0) has to be two arguments. And naturally there is no confusion about 
    the ordering of the arguments here.
    - Try naming the method in such a way that argument order is not explicit - 
    assertExpectedEqualsActual(A,B)
    - Three arguments is clearly a trouble - start making object that can carry the arguments
    - Varargs are one argument
 5. No side effects - Write functions that only does what it intends to do. Naming a function as 
    CheckPassword and then initializing the session inside this function will cause side effects. 
    Consumers of this method will be unaware of this sideeffect.
 6. Command Query Separation: Functions should either do something or answer something, but not 
    both. 
     if(attributeExists(userName))
     {
        setAttribute(userName,value);
     }
 7. Prefer Exception to returning error code
    Returning error code will form a deeply nested structure. Where in, returning exception will 
    help moving the exception handling code from functional code.
    if(deletePage() == E_OK)
    {
      if(deleteReference() == E_OK)
      {
        if(deleteKey() == E_OF)
        ...
      }
    }
    
    can be avoided if exceptions are used
    try{
    deletePage();
    deleteReference();
    deleteKey();
    }
    catch(Exception e){
    }
    
 8. Extract try/catch blocks - push the exception handling logic to its own method
 9. Error handling is one thing - a function handling exception should just do that. It should have 
 try as first statement and nothing after catch/finally
 10. Don't repeat yourself - avoid duplicate code
 11. Structured programming - Every function, every block within a function should have only one 
 entry and one exit. So no multi returns, break & continue and goto.
 - But with small functions multi returns, break and continue are okay at times
 - but never ever GOTO
 