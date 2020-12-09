package com.epam.rd.at.java_basics.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private void provideInput(String... data) {
        String collect = String.join("\n", data);
        testIn = new ByteArrayInputStream(collect.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    private String getResult() {
        String output = getOutput();
        Matcher matcher = Pattern.compile("Result\\s?=\\s?(-?\\d+)").matcher(output);
        return matcher.find() ? matcher.group(1) : null;
    }

    @Test
    public void whenTwoPlusThreeThenReturnsFive() {
        provideInput("2", "+", "3");
        CalculatorMain.main(new String[0]);
        String result = getResult();
        assertEquals("5", result);
    }

    @Test
    public void whenFiveMinusTenThenReturnsMinusFive() {
        provideInput("5", "-", "10");
        CalculatorMain.main(new String[0]);
        String result = getResult();
        assertEquals("-5", result);
    }

    @Test
    public void whenFourMultipliedByThreeThenReturnsTwelve() {
        provideInput("4", "*", "3");
        CalculatorMain.main(new String[0]);
        String result = getResult();
        assertEquals("12", result);
    }

    @Test
    public void whenSixDivideByMinusTwoThenReturnsMinusThree() {
        provideInput("6", "/", "-2");
        CalculatorMain.main(new String[0]);
        String result = getResult();
        assertEquals("-3", result);
    }

    @Test
    public void whenSixDivideByZeroThenReturnsError() {
        provideInput("6", "/", "0");
        CalculatorMain.main(new String[0]);
        assertTrue(getOutput().contains("Error: divide by zero"));
        assertNull(getResult());
    }

    @Test
    public void whenTwoPlusZeroThenNoError() {
        provideInput("6", "+", "0");
        CalculatorMain.main(new String[0]);
        String result = getResult();
        assertEquals("6", result);
    }

    @Test
    public void whenIncorrectOperationThenReturnsError() {
        provideInput("6", "&", "2");
        CalculatorMain.main(new String[0]);
        assertTrue(getOutput().contains("Error"));
        assertNull(getResult());
    }

    @Test
    public void whenIncorrectOperationThenReturnsError2() {
        provideInput("6", "++", "2");
        CalculatorMain.main(new String[0]);
        assertTrue(getOutput().contains("Error"));
        assertNull(getResult());
    }

    @Test
    public void whenIncorrectNumberAThenReturnsError() {
        provideInput("6a", "+", "2");
        CalculatorMain.main(new String[0]);
        assertTrue(getOutput().contains("Error"));
        assertNull(getResult());
    }

    @Test
    public void whenIncorrectNumberBThenReturnsError() {
        provideInput("6", "+", "2a");
        CalculatorMain.main(new String[0]);
        assertTrue(getOutput().contains("Error"));
        assertNull(getResult());
    }
}