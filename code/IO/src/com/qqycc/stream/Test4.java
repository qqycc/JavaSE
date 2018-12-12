package com.qqycc.stream;

import java.io.*;

/**
 * 字符输入流
 * Author: qqy
 */
public class Test4 {
    public static void main(String[] args) throws IOException {
        //1.取得File对象
        File file = new File("E:"+File.separator+"JAVA"+File.separator+"TestSerializable.txt");
        //2.取得输入流
        Reader reader= new FileReader(file);
        //3.读取数据
        char[] data=new char[1024];
        //个数
        int result=reader.read(data);
        System.out.println(result);
        System.out.print(new String(data,0,result));
        //4.关闭流
        reader.close();
    }
}
