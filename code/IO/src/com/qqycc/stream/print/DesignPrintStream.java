package com.qqycc.stream.print;

import java.io.*;
import java.nio.file.Paths;

/**
 * 设计打印流
 * Author: qqy
 */
public class DesignPrintStream {
    public static void main(String[] args) {
        //DesignPrintStream print = new DesignPrintStream(System.out);
        DesignPrintStream print =null;
        try {
            print = new DesignPrintStream(
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

    private OutputStream outputStream;

    public DesignPrintStream(OutputStream outputStream){
        this.outputStream=outputStream;
    }

    public void print(String str){
        try {
            //核心在于OutputStream提供的write
            outputStream.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(String str){
        print(str+"\r\n");
    }

    public void println(int value){
        println(String.valueOf(value));
    }

    public void println(double value){
        println(String.valueOf(value));
    }

    public void println(boolean value){
        println(String.valueOf(value));
    }
}
