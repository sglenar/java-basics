package com.epam.rd.at.java_basics.exercises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersArrayTest {

    @Test
    void sumElementsOnEvenPositions() {
        int[] array = {1, -2, 2, 3, 1, -5, -10};
        int result = NumbersArray.sumElementsOnEvenPositions(array);
        assertEquals(-6, result, "Result is incorrect for array: " + Arrays.toString(array));
    }

    @Test
    void replaceNegativeElementsByZero() {
        int[] originalArray = {1, -2, 0, 3, 1, -5, -10};
        int[] array = Arrays.copyOf(originalArray, originalArray.length);
        NumbersArray.replaceNegativeElementsByZero(array);
        int[] expected = {1, 0, 0, 3, 1, 0, 0};
        assertArrayEquals(expected, array, "Result is incorrect for array: " + Arrays.toString(originalArray));
    }

    @Test
    void generateFibonacciNumbers() {
        int[] array1 = NumbersArray.generateFibonacciNumbers(14);
        int[] expected1 = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233};
        assertArrayEquals(expected1, array1, "Incorrectly generated Fibonacci numbers for x = 14");

        int[] array2 = NumbersArray.generateFibonacciNumbers(1);
        int[] expected2 = {0};
        assertArrayEquals(expected2, array2, "Incorrectly generated Fibonacci numbers for x = 0");

        int[] array3 = NumbersArray.generateFibonacciNumbers(2);
        int[] expected3 = {0, 1};
        assertArrayEquals(expected3, array3, "Incorrectly generated Fibonacci numbers for x = 0");
    }

    @Test
    void generatePrimeNumbers() {
        int[] array = NumbersArray.generatePrimeNumbers(10);
        int[] expected = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        assertArrayEquals(expected, array, "Incorrectly generated prime numbers");
    }

    @Test
    void countNumbersWithEqualCountOfEvenAndOddDigits() {
        int[] array = {11, 12, -22, -25, 145, 1588, 0, 10};
        int result = NumbersArray.countNumbersWithEqualCountOfEvenAndOddDigits(array);
        assertEquals(4, result, "Result is incorrect for array: " + Arrays.toString(array));
    }

    @Test
    void countNumbersWithOnlyUniqueDigits() {
        int[] array = {11, 12, -22, -252, 145, 1588, 484, -1907, 0};
        int result = NumbersArray.countNumbersWithOnlyUniqueDigits(array);
        assertEquals(4, result, "Result is incorrect for array: " + Arrays.toString(array));
    }

    @Test
    void rotateArray() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] result = NumbersArray.rotateArray(array);
        int[][] expected = {
                {4, 1},
                {5, 2},
                {6, 3}
        };
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], result[i], "Result is incorrect for array row #" + i);
        }
    }

    @Test
    void findDuplicates() {
        int[] array = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 2, -1, 2, 0, 3, 43, 5, 5, 5, 1, 1, 1, 2, -1, -1, 0, 0};
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 7);
        expected.put(2, 7);
        expected.put(3, 4);
        expected.put(-1, 3);
        expected.put(5, 3);
        expected.put(0, 3);
        Map<Integer, Integer> result = Stream.of(NumbersArray.findDuplicates(array)).collect(Collectors.toMap(r -> r[0], r -> r[1]));
        assertEquals(expected, result, "Result is incorrect for array: " + Arrays.toString(array));
    }
}