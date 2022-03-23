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
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // task 6
    public static int countNumbersWithOnlyUniqueDigits(int[] array) {
        throw new UnsupportedOperationException("Not implemented yet");
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
