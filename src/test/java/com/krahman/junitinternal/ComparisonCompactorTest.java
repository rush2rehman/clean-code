package com.krahman.junitinternal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComparisonCompactorTest {

    @Test
    public void testMessage(){
        String failure = new ComparisonCompactor(0,"b","c").formatCompactedComparison("a");
        assertEquals("a expected:<[b]> but was:<[c]>", failure);
    }

    @Test
    public void testCommonPrefix(){

        assertTrue(findCommonPrefix(0,"a","a") == 1);
        assertTrue(findCommonPrefix(0,"a","b") == 0);
        assertTrue(findCommonPrefix(0,"abc","a") == 1);
        assertTrue(findCommonPrefix(0,"a","abc") == 1);
        assertTrue(findCommonPrefix(0,"bc","abc") == 0);
        assertTrue(findCommonPrefix(0,"abcdef","abc") == 3);

    }

    @Test
    public void testCommonSuffix(){
        assertTrue(findCommonSuffix(0,"a","a") == 0);
        assertTrue(findCommonSuffix(0,"a","b") == 0);
        assertTrue(findCommonSuffix(0,"abc","a") == 0);
        assertTrue(findCommonSuffix(0,"c","abc") == 1);
        assertTrue(findCommonSuffix(0,"b","abc") == 0);
        assertTrue(findCommonSuffix(0,"bc","abc") == 2);
        assertTrue(findCommonSuffix(0,"abcdef","def") == 3);

    }

    @Test
    public void testCompactString(){
        ComparisonCompactor comparisonCompactor = new ComparisonCompactor(0,"b","c");
        comparisonCompactor.findCommonPrefixAndSuffixLength();
        assertTrue(comparisonCompactor.compact("b").equals("[b]"));


    }

    private int findCommonPrefix(int contextLength, String expected, String actual){
        ComparisonCompactor comparisonCompactor = new ComparisonCompactor(contextLength,expected,actual);
        comparisonCompactor.findCommonPrefixLength();
        return comparisonCompactor.getCommonPrefixLength();
    }
    private int findCommonSuffix(int contextLength, String expected, String actual){
        ComparisonCompactor comparisonCompactor = new ComparisonCompactor(contextLength,expected,actual);
        comparisonCompactor.findCommonPrefixAndSuffixLength();
        return comparisonCompactor.getCommonSuffixLength();
    }
}
