## Unit Tests
### GoldenRules
1. Rules of TDD:
    - You may not write production code until you have written a failing unit test
    - You may not write more of a unit test than is sufficient to fail
    - You may not write more production code that is sufficient to pass the currently failing test.
2. Most important aspect of test code is - readability
3. As we write test cases, create domain specific language to test efficiently - this DSL is nothing but specialized set
    of APIs/methods used by unit tests
4. It is okay to have dual engineering standards - for production and test code. Thats mainly because of the fact that
test code doesnt run in prod and doesnt have the same constraints as that of production env.
    - Some of the examples of relaxing the rules could be:
        - using metal mapping could be appropriate in some cases
        - String buffer usage in a test case
5. **One assert per test** Rather than saying exactly 1 assert per test, the rule should be - number of asserts in a
    test need to be minimized. The better rule is single concept per test.
6. **F.I.R.S.T**
    - FAST - should run fast - else we will find reasons not to run the tests frequently
    - INDEPENDENT - each test should be independent of each other
    - REPEATABLE - Any where, any environment, any time runnable. No dependency on the network.
    - SELF-VALIDATING - Should return a boolean result, not a file which we will parse and deduce the result
    - TIMELY - Write it before writing production code
