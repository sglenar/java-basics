package com.epam.rd.at.java_basics.exercises;

public class StringsArray {

    // task 1
    public static String findShortestString(String[] array) {
        String shortestElement = findFirstNotNull(array);
        if (shortestElement == null) {
            return null;
        } else if (array.length > 0) {
            for (String element : array) {
                if (element.length() <= shortestElement.length() && element.length() > 0) {
                    shortestElement = element;
                }
            }
        }
        return shortestElement;
    }

    private static String findFirstNotNull(String[] array) {
        String firstNotNullElement = new String();
        for (String element : array) {
            if (element.length() > 0) {
                firstNotNullElement = element;
                return firstNotNullElement;
            }
        }
        return null;
    }

    // task 2
    public static String[] findLongStrings(String[] array) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // task 3
    public static String findStringWithDigitsOnly(String[] row) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // task 4
    public static int countStringsWithUniqueCharacters(String[] array) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
