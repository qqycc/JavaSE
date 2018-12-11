package com.qqycc.encoding;

import java.io.*;
import java.nio.file.Paths;

/**
 * 乱码的产生
 * Author: qqy
 */
public class Test {
    public static void main(String[] args) {
        File file=Paths.get("E:","JAVA","Test.txt").toFile();
        try( FileOutputStream out=new FileOutputStream(file);
        ) {
            //统一采用UTF-8
           out.write("你好hello".getBytes("ISO-8859-1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
