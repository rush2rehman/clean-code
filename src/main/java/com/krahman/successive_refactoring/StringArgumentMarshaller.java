package com.krahman.successive_refactoring;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class StringArgumentMarshaller implements ArgumentMarshaller {

    private String stringValue;

    @Override
    public void set(ListIterator<String> argumentListIterator) throws ArgumentException {
        try {
            stringValue = argumentListIterator.next();
        }
        catch(NoSuchElementException e){
            throw new ArgumentException();
        }
    }

    public static String getValue(ArgumentMarshaller argumentMarshaller){
        if(argumentMarshaller != null && argumentMarshaller instanceof StringArgumentMarshaller)
            return ((StringArgumentMarshaller)argumentMarshaller).stringValue;
        else
            return "";
    }
}
