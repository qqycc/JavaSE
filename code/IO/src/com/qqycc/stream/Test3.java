package com.qqycc.stream;

import java.io.*;

/**
 * 字符输出流
 * Author: qqy
 */
public class Test3 {
    public static void main(String[] args) throws IOException {
        //1.取得File对象
        File file = new File("E:"+File.separator+"JAVA"+File.separator+"TestSerializable.txt");
        //2.取得输出流
        Writer writer=new FileWriter(file);
        //3.写入数据
        String str="你好 Bonjour！";
        writer.write(str);
        //4.关闭流
        writer.close();
    }
}
