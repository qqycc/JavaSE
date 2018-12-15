package com.qqycc.stream.print;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Paths;

/**
 * PrintStream
 * Author: qqy
 */
public class Test {
    public static void main(String[] args) {
        PrintStream print =null;
        try {
            print = new PrintStream(
                    new FileOutputStream(Paths.get("E:","JAVA","TestSerializable.txt").toFile())
            );
            print.println("Hello");
            print.println(10);
            print.println(10.0d);
            print.println(true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
