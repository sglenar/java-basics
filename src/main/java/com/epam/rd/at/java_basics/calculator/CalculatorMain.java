package com.epam.rd.at.java_basics.calculator;

import javax.print.attribute.standard.PresentationDirection;
import java.util.Arrays;
import java.util.Scanner;

public class CalculatorMain {

    public static void main(String[] args) {
        String plus = "+";
        String minus = "-";
        String multipl = "*";
        String divis = "/";
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Calculator App!" +"\nTo start, enter number A, operation (+, -, * or /) and number B ");
        System.out.println("Enter number A:");
        String stringA = scan.next();
        int numberA;
        if (isNumber(stringA)) {
            numberA = Integer.parseInt(stringA);
        } else {
            return;
        }
        System.out.println("Choose operation:");
        String operator = String.valueOf(scan.next());
        if (!Arrays.asList("+", "-", "*", "/").contains(operator)) {
            System.out.println("Error");
            System.out.println("Incorrect operator");
            return;
        }
        System.out.println("Enter number B:");
        String stringB = scan.next();
        int numberB;
        if (isNumber(stringB)) {
            numberB = Integer.parseInt(stringB);
        } else {
            return;
        }
        double result = 0;
        if (operator.equals(plus) ) {
            result = sum(numberA,numberB);
        } else if (operator.equals(minus)) {
            result = difference(numberA,numberB);
        } else if (operator.equals(multipl)) {
            result = multiplication(numberA,numberB);
        } else if (operator.equals(divis)) {
            result = division(numberA,numberB);
            if (numberB == 0) {
            return;
            }
        }
        System.out.println("Result = " + result);




    }

    private static double sum(int a, int b) {
        return a+b;
    }
    private static double  difference (int a, int b) {
        return a-b;
    }
    private static double multiplication (int a, int b) {
        return a*b;
    }
    private static double division (int a, int b) {
        double result = 0;
        try {
            result = a/b;
        } catch (ArithmeticException e) {
            System.out.println("Error: divide by zero");
            //return null;
        }
        return  result;
    }
    private static boolean isNumber (String enteredNumber) {
        try {
            Integer.parseInt(enteredNumber);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error");
            System.out.println("Entered symbol is not a number");
            return false;
        }
    }
}


