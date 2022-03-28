package com.epam.rd.at.java_basics.calculator;

import java.util.Scanner;

public class CalculatorMain {

    public static void main(String[] args) {
        double result = 0;
        String plus = "+";
        String minus = "-";
        String multipl = "*";
        String divis = "/";
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number A:");
        double numberA = Integer.parseInt(scan.next());
        System.out.println("Choose operation:");
        String operator = String.valueOf(scan.next().charAt(0));
        System.out.println("Enter number B:");
        double numberB = Integer.parseInt(scan.next());
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

    private static double sum(double a, double b) {
        return a+b;
    }
    private static double  difference (double a, double b) {
        return a-b;
    }
    private static double multiplication (double a, double b) {
        return a*b;
    }
    private static double division (double a, double b) {
        return a/b;
    }
}


