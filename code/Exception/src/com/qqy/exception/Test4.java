package com.qqy.exception;

/**
 * Author: qqy
 */
public class Test4 {
    public static void main(String[] args) {
        try {
            div(10, 2);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int div(int a, int b) throws ArithmeticException {
        try {
            return a / b;
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }
}
