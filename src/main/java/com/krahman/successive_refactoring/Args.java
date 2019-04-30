package com.krahman.successive_refactoring;

import java.util.*;

public class Args {

    private Map<Character, ArgumentMarshaller> schemaMap;
    private Set<Character> argsFound;
    private ListIterator<String> currentArgument;

    public Args(String schema, String[] inArgs) throws ArgumentException {
        schemaMap = new HashMap<>();
        argsFound = new HashSet<>();
        parseScheme(schema);
        parseArgumentList(inArgs);

    }

    private void parseScheme(String schema) throws ArgumentException {
        String[] elementList = schema.split(",");
        for(String element: elementList){
            if (element.length() > 0){
               parseSchemaElement(element.trim());
            }
        }
    }

    private void parseSchemaElement(String element) throws ArgumentException {
        char elementId = element.charAt(0);
        validateElementId(elementId);
        if(element.length() == 1)
            schemaMap.put(elementId, new BooleanArgumentMarshaller());
        else{
            String schemaNotation = element.substring(1);
            if(schemaNotation.equals("#"))
                schemaMap.put(elementId,new IntegerArgumentMarshaller());
            else if(schemaNotation.equals("*"))
                schemaMap.put(elementId, new StringArgumentMarshaller());
            else
                throw new ArgumentException();
        }
    }

    private void validateElementId(char elementId) throws ArgumentException {
         if(!Character.isLetter(elementId))
             throw new ArgumentException();
    }

    private void parseArgumentList(String[] inArgs) throws ArgumentException {
        for(currentArgument = Arrays.asList(inArgs).listIterator();currentArgument.hasNext();){
            String inArgString = currentArgument.next();
            if(inArgString.startsWith("-")) {
                parseArgumentCharacters(inArgString.substring(1));
            }else {
                currentArgument.previous();
                break;
            }

        }
    }

    private void parseArgumentCharacters(String substring) throws ArgumentException {
        for(int index = 0; index < substring.length(); index++){
            char elementId = substring.charAt(index);
            ArgumentMarshaller argumentMarshaller = schemaMap.get(elementId);
            if(argumentMarshaller == null){
                throw new ArgumentException();
            }
            else{
                argumentMarshaller.set(currentArgument);
            }
        }

    }

    private static void executeApplication(boolean readOnly, int port, String protocol) {
        System.out.println("Boolean :"+readOnly+"\nInteger :"+port+"\nString :"+protocol);
    }


    private String getString(char arg) {
        return StringArgumentMarshaller.getValue(schemaMap.get(arg));
    }

    private int getInteger(char arg) throws ArgumentException{
        return IntegerArgumentMarshaller.getValue(schemaMap.get(arg));
    }

    private boolean getBoolean(char arg) {
        return BooleanArgumentMarshaller.getValue(schemaMap.get(arg));
    }

    public static void main(String[] inArgs)
    {
        try{
            Args args = new Args("l,p#,d*", inArgs);
            boolean readOnly = args.getBoolean('1');
            int port = args.getInteger('p');
            String protocol = args.getString('d');
            executeApplication(readOnly,port,protocol);
        }
        catch(ArgumentException e){
            System.out.println("Exception while processing arguments"+ e.getMessage());
        }
    }

}
