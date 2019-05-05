package com.krahman.cleancode.successive_refactoring;

import java.util.ListIterator;

public interface ArgumentMarshaller {

    void set(ListIterator<String> argumentListIterator) throws ArgumentException;
}
