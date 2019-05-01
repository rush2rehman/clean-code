package com.krahman.junitinternal;


public class ComparisonCompactor {

    private static final String DELTA_START = "[";
    private static final String DELTA_END = "]";
    private String expected;
    private String actual;
    private int contextLength;
    private int commonPrefixLength;
    private int commonSuffixLength;

    public ComparisonCompactor(int contextLength , String expected, String actual) {
        this.contextLength = contextLength;
        this.expected = expected;
        this.actual = actual;
    }

    public String formatCompactedComparison(String message) {
        findCommonPrefixAndSuffixLength();
        String compactedExpected = compact(expected);
        String compactedActual = compact(actual);
        return new StringBuilder().append(message)
                .append(" expected:<")
                .append(compactedExpected)
                .append(">")
                .append(" but was:<")
                .append(compactedActual)
                .append(">")
                .toString();
    }


    void findCommonPrefixAndSuffixLength() {
        findCommonPrefixLength();
        int commonSuffix = 0;
        int expectedIndex = expected.length()-1;
        int actualIndex = actual.length()-1;
        for(;!prefixOvelapsSuffix(expectedIndex,actualIndex);commonSuffix++){
            if(expected.charAt(expectedIndex) != actual.charAt(actualIndex))
                break;
            expectedIndex--;
            actualIndex--;
        }
        commonSuffixLength = commonSuffix;
    }

    private boolean prefixOvelapsSuffix(int expectedIndex, int actualIndex) {
        return expectedIndex == commonPrefixLength-1
                || actualIndex == commonPrefixLength-1;
    }

    void findCommonPrefixLength() {
        int prefixLimit = Math.min(expected.length(),actual.length());
        int commonPrefix = 0;
        for(;commonPrefix < prefixLimit; commonPrefix++){
            if(expected.charAt(commonPrefix) != actual.charAt(commonPrefix))
                break;
        }
        commonPrefixLength = commonPrefix;
    }


    public int getCommonPrefixLength() {
        return commonPrefixLength;
    }

    public int getCommonSuffixLength() {
        return commonSuffixLength;
    }


    public String compact(String stringToBeCompacted) {

        return new StringBuilder()
                .append(DELTA_START)
                .append(getDeltaString(stringToBeCompacted))
                .append(DELTA_END)
                .toString();


    }

    private String getDeltaString(String inputString) {
            return inputString.substring(commonPrefixLength,inputString.length()-commonSuffixLength);
          }
}
