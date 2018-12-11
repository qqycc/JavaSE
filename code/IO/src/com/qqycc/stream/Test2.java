package com.qqycc.stream;

import java.io.*;

/**
 * 字节输入流
 * Author: qqy
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        //1.取得File对象
        File file = new File("E:"+File.separator+"JAVA"+File.separator+"TestSerializable.txt");
        //2.取得输入流
        InputStream in= null;
        OutputStream out=null;
        try {
            in = new FileInputStream(file);
            out=new FileOutputStream(file);
            int value=-1;
            //输入
            while((value=in.read())!=-1){
                //程序中进行数据的处理
                value+=32;
                //输出
                out.write(value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //3.读取文件内容
        byte[] data=new byte[1024];
        int res= 0;
        try {
            res = in.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(res);
        System.out.println(new String(data));
        //4.关闭输入流
        in.close();
    }
}
