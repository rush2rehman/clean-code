## Formatting
### Golden Rules
1. **Vertical Formatting**
    1. **Vertical openness** : Give blank lines between different segments of lines.. for example 
    provide blank lines between package declaration and imports. Give  blank lines btween import 
    statements and class declaration. Blank line between methods and so on
    2. **Vertical density** : Its the reverse of the Vertical openness. Keep associated lines 
    together.
    3. **Vertical Distance** : Related blocks of codes should be kept close to each other.  
      - Local Variable declaration : local variables within a function should be declared close to their 
      usage - by principle if the methods are small, local variables will be always at the beginning 
      of functions. But the loop variables should be declared within the loop statement
      - Instance Variables - should always be declared at the top. Thats because, in a correctly 
      designed class many functions will be using the instance variables. So it makes sense to keep 
      them at the top.
      - Dependent functions: If one function is calling another function, they should be vertically 
      close. If possible, caller should be above the callee.
2. **Horizontal formatting:**
    1. **Horizontal openness and density** : space between assignment operands, method call 
    signature without any space. Use space to accentuate the precedence of operators.
    2. **Horizontal alignment** : proper indentation
    3. curly braces opening on the same line - 
    try {
    }
    4. Highlighting dummy scope  - single line loop to have ; in a new line.
   