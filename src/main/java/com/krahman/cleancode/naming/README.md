## Naming

### **Golden Rules:**
1. **Use intention revealing names** - do not use x, y, list , list1 kind of names. The code should have 
meaningful names to reveal the intent
2. **Avoid disinformation** 
    - names that mimic OS parameters
    - suffixing the variable name with list unless the data structure itself is a List
    - Variable names that look very similar - XYZControllerForEfficeintHandlingOfString vs 
    XYZControllerForEfficientStorageOfStrings
    - lower case l and upper case O - mimic 1(one) and 0(zero)   
3. **Make meaningful distinction** 
    - productInfo and productData
    - AddressString - why String? 
    - getActiveAccount(), getActiveAccounts(), getActiveAccountInfo() -- very confusing for the 
    caller
4. **Use Pronounceable names**
5. **Use Searchable Names**
    - single letter names are obvious problems
    - _Length of the name should correspond to the size of its scope_ - smaller the scope, you can 
     small names. For instance in a simple for loop you might use sum or count. But in a
     bigger context like a method or class, since the var has to co-exist with many other variable, 
     give it a bigger/meaningful name.    
6. **Avoid Encoding**
    -  avoid adding the type to the variable name - phoneString
    -  avoid member prefix m_
    -  Adding I in front of the interface is also not a recommended practice
7. **Class Names**
    - _Class names should be a noun. Verbs should not be a class name_
    - Avoid Manager, data, info, processor in class names - this leads to anti-pattern called God 
    Classes. God classes are the ones that know too much and many other objects depend upon this.
8. **Method Names**
    - Method names should be verbs
    - Use get, set, is as prefix for accessors, mutators and predicates respectively
    - Wherever there are multiple constructors, try using teh factory methods (while the setting the 
    constructors private). This makes teh context clear for the consumer
       ex. Bus bus = Bus.FromMakeAndModel("","");
       Bus bus = Bus.FromSize(1,2,3);
9. **Pick one word per concept**
    - be consistent - fetch, retrieve, get
10. **Add meaningful context**
    - Providing a shorter/appropriate context for Naming could be  one of the reasons to refactor a 
    lengthy method into smaller methods.
    - If you see a big method and the context of the variables is confusing because of the multiple 
    conditional blocks - then refactor and create multiple methods to provide shorter context to 
    variable names. Here the variables might need to be promoted to class level.
 11. **Don't add gratuitous context**
    - Prefixing with GSD..XXX and so on
    