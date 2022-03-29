package com.epam.rd.at.java_basics.calculator;

import java.util.Scanner;

public class CalculatorMain {

    public static void main(String[] args) {
        int result = 0;
        String plus = "+";
        String minus = "-";
        String multipl = "*";
        String divis = "/";
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number A:");
        int numberA = Integer.parseInt(scan.next());
        System.out.println("Choose operation:");
        String operator = String.valueOf(scan.next());
        System.out.println("Enter number B:");
        int numberB = Integer.parseInt(scan.next());
        if (operator.equals(plus) ) {
            result = sum(numberA,numberB);
        } else if (operator.equals(minus)) {
            result = difference(numberA,numberB);
        } else if (operator.equals(multipl)) {
            result = multiplication(numberA,numberB);
        } else if (operator.equals(divis)) {
            result = division(numberA,numberB);
        }
        System.out.println("Result = " + result);




    }

    private static int sum(int a, int b) {
        return a+b;
    }
    private static int  difference (int a, int b) {
        return a-b;
    }
    private static int multiplication (int a, int b) {
        return a*b;
    }
    private static int division (int a, int b) {
        int result = 0;
        try {
            result = a/b;
        } catch (ArithmeticException e) {
            System.out.println("Error: divide by zero");
        }
        return  result;
    }

}


