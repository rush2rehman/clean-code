## Comments
### golden rules
1. Comments are failures of self explaining code - use them when there is no better way of writing 
   expressive code
2. **Good comments**
    1. Legal comments - use links rather than dumping all the info that can change
    2. Explanation of intent - like a piece of code that is written to avoid race condition
    3. Warning of consequences - like a code that will trigger a long running process.
    4. TODO comments
    5. Amplification - stress the importance of a function of variable
    6. Java doc for public APIs
3. **Bad Comments**
    1. Mumbling - Any comment that makes you to lookup another module
    2. Redundant comments
    3. Mandated comments - written just for the sake of mandate
    4. Journal comments(Change history) - Source control can solve
    5. Position markers like ///Actions related code///
    6. Closing brace comments like }//while - may be a lengthier function needs refactoring
    7. Attributions and Bylines - credits - Source control
    8. Commented out code
    9. HTML comments - should be taken care by comment rendering framework
    10. Too much info - like history and background
    11. Java doc on non public code
    