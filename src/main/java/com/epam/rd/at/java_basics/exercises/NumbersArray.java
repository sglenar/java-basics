package com.epam.rd.at.java_basics.exercises;

public class NumbersArray {

    // task 1
    public static int sumElementsOnEvenPositions(int[] array) {
        int summary = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                summary += array[i];
            }
        }
        return summary;
    }

    // task 2
    public static void replaceNegativeElementsByZero(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = 0;
            }
        }
    }

    // task 3
    public static int[] generateFibonacciNumbers(int count) {
        int[] array = new int[count];
        if (count >= 2) {
            array[0] = 0;
            array[1] = 1;
            for (int i = 2; i < count; i++) {
            array[i] = array[i-2] + array[i-1];
            }
        } else if (count == 1) {
            array[count - 1] = 0;
        }
        return array;
        }

    // task 4
    public static int[] generatePrimeNumbers(int count) {
        int[] array = new int[count];
        int i = 0;
        int j = 2;
        while (i < count) {
            if (isPrimeNumber(j)) {
                array[i] = j;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return array;
    }
    private static boolean isPrimeNumber(int number) {
        for (int i = 2; i*i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // task 5
    public static int countNumbersWithEqualCountOfEvenAndOddDigits(int[] array) {
        int equalCounter = 0;
        for (int j : array) {
            if (countOddDigits(j) == countEvenDigits(j)) {
                equalCounter += 1;
            }
        }
        return equalCounter;
    }
    private static int countEvenDigits(int number) {
        int evenDigitsNumber = 0;
        while (number / 10 >= 1) {
            int intermediateNumber = 0;
            intermediateNumber = number % 10;
            if (intermediateNumber % 2 == 0) {
                evenDigitsNumber  += intermediateNumber;
            }
            number /= number;
        }
        return evenDigitsNumber;
    }
    private static int countOddDigits(int number) {
        int oddDigitsNumber = 0;
        while (number / 10 >= 1) {
            int intermediateNumber = 0;
            intermediateNumber = number % 10;
            if (intermediateNumber % 2 == 1) {
                oddDigitsNumber  += intermediateNumber;
            }
            number /= number;
        }
        return oddDigitsNumber;
    }

    // task 6
    public static int countNumbersWithOnlyUniqueDigits(int[] array) {
        int uniqueDigitsNumberCounter = 0;
        for (int element : array) {
            boolean isUnique = true;
            char[] chars = String.valueOf(Math.abs(element)).toCharArray();
            for (int i = 0; i < chars.length - 1; i++) {
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] == chars[j]) {
                        isUnique = false;
                        break;
                    }
                }
                if (!isUnique) {
                    break;
                } else {
                    uniqueDigitsNumberCounter += 1;
                    break;
            }
        }
    }
        return  uniqueDigitsNumberCounter;
    }

    // task 7
    public static int[][] rotateArray(int[][] array) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // task 8
    public static int[][] findDuplicates(int[] array) {
        throw new UnsupportedOperationException("Not implemented yet");
    }


}
