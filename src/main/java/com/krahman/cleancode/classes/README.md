## Classes
### Golden rules
1. **Class organization**
    - The order shall be : public static var, private static var, instance var, pub function, private functions
2. **Encapsulation** sometimes keeping the methods protected for teh purpose of test cases is okay.
3. **Classes should be small**
    - If we cannot derive concise name for a class - indication of a larger class
    - Processor, manager or super names classes are usually aggregation of multiple responsibilities
4. SRP
    - Cohesion:
        Classes should have minimum number of instance variables, a class with each variable being used by each 
        method is a highly cohesive one - which is good. 
    - Maintaining cohesion results in many small classes
        In an attempt to break a large method with many local variables into smaller ones, we identify certain variables
        to be lifted to instance level. Now this triggers teh cycle of too many instance variables prompting refactoring
        of the class.
    - Util classes are okay to have - should not be instantiated though
 5. Isolation for change
    - Dependencies upon concrete classes create challenges for testing our systems. DIP(dependency inversion principle)
    is - our classes should be dependent on abstraction, not concrete classes. So its always good to abstract the
     interaction with third party.