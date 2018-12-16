package com.qqycc.stream.system;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Author: qqy
 */
public class Test {
    public static void main(String[] args) {
        try{
            OutputStream out=System.out;
            out.write("hello".getBytes());
            System.err.println("bonjour");
            Integer.parseInt("123aaa");
        }catch (NumberFormatException e){
            System.out.println(e);
            System.err.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
