package com.qqy.jcf;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Enumeration
 * Author:qqy
 */
public class Test11 {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Java");
        vector.add("C++");
        vector.add("Python");
        Enumeration enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}
