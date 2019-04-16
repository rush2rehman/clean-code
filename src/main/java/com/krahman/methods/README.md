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
 5. No side effects