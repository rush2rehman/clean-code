## Objects Data Structures
### Golden Rules
1. **What is the difference between an Object and a data structure**
      - An object doesnt simply push its variable through getters and setters. It exposes behaviour, 
      in other words it exposes abstract interfaces that allows the users to manipulate the essence 
      of the data, without having to know the implementation.
      - Where in a data structure simply has getters and setters (which could have been achieved 
      through public variables - as there is no difference)
      - Everything can be modelled as object - is a myth. With experience, programmers understand 
      when to use object and when to use simple data structures
      - When using data structures(procedural code) it becomes easy to add methods without 
      changing the data structure
      - When using objects(OO code) it becomes easy to add classes without changing the methods
2. **Law of Demeter(talk to friends not strangers)** 
      - A method f of class C should only call methods of
        C
        objects created by f
        Objects held as instance variable of C
        Objects passed as arguments
      
      Below seems to be a violation of demeter law as this line asking for absolute data from a 
      stranger class
      final String outputDir = ctxt.getOptions().getScratchDir().getAbsolutePath();
      If this had been a chain of calls to data structures - no problem
      final String outputDir = ctxt.options.scratchdir.absolutepath;
      
      But assuming thats a object method chain, the right thing to do would be asking ctxt object to
      do something rather than asking for data structure kind of behaviour
      So instead of asking for a absolute path, ctxt could abstract the file creation and return 
      back the buffered output stream
      BufferedOutputStream boutstream = ctxt.createScratchFileFromStream(classFileName);
      
3. **DTO** A quintessential form of data structures. The getters and setters of these classes are 
      just name sake.
4. **Active Records** The special DTOs with find and save. Developers often add business logic here 
which is not the right thing to do. We should have a separate class with behaviour, and leave Active
Records as data structures. The clsss with behaviour might hide the data (where teh data could be 
just the active records)
            
      
        