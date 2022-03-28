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
        String firstNotNullElement;
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
        String[] resultArrayWithNull = new String[1];
        int averageLenght = findAverageLength(array);
        for (String element : array) {
            if (element.length() >= averageLenght) {
                resultArrayWithNull = makeArrayBigger(resultArrayWithNull);
                resultArrayWithNull[(resultArrayWithNull.length) - 1] = element + "=" + element.length();
            }
        }
        String[] resultArray = new String[resultArrayWithNull.length - 1]; // array without Null as 1st element
        for (int i = 1; i < resultArrayWithNull.length; i++) {
            resultArray[i - 1] = resultArrayWithNull[i];
        }
        return resultArray;
    }

    private static int findAverageLength(String[] array) {
        int averageLenght ;
        int sumOfAllLenghts = 0;
        for (String element : array) {
            sumOfAllLenghts += element.length();
        }
        averageLenght = sumOfAllLenghts / array.length;
        return averageLenght;
    }

    private static String[] makeArrayBigger(String[] array) {
        String[] resultArray = new String[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            resultArray[i] = array[i];
        }
        return resultArray;
    }


    // task 3
    public static String findStringWithDigitsOnly(String[] row) {
        String[] resultArray = new String[1];
        for (String element : row) {
            if (isStringWithNumbersOnly(element)) {
                resultArray[resultArray.length - 1] = element;
                resultArray = makeArrayBigger(resultArray);
            }
        }
        if (resultArray.length == 1) {
            return null;
        } else if (resultArray.length == 2) {
            return resultArray[0];
        } else {
            return resultArray[1];
        }
    }

    private static boolean isStringWithNumbersOnly(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // task 4
    public static int countStringsWithUniqueCharacters(String[] array) {
        int counter = 0;
        for (String element : array) {
            if (isStringHasUniqueCharacters(element) && element != "") {
                counter +=1;
            }
        }
        return  counter;
    }

    private static boolean isStringHasUniqueCharacters(String string) {
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] == charArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
