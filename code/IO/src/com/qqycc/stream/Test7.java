package com.qqycc.stream;

import java.io.*;

/**
 * 转换流
 * Author: qqy
 */
public class Test7 {
    public static void main(String[] args) throws IOException {
        //1.取得文件对象
        File file = new File ("E:"+File.separator+"JAVA"+File.separator+"TestSerializable.txt");
        //2.取得输出流
        OutputStream outputStream=new FileOutputStream(file);
        //3.字节流变为字符流,注意编码格式
        OutputStreamWriter out=new OutputStreamWriter(outputStream);
        out.write("你好 Bonjour");
        //4.关闭流
        out.close();
    }
}
