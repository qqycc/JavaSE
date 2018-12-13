package com.qqycc.stream.memory;

import java.io.*;

/**
 * 内存流应用
 * Author: qqy
 */
public class Test {
    public static void main(String[] args) {
        //内存流实现字母转换
        //方法一：
        String msg="hello";
        //取得内存流
        ByteArrayInputStream inputStream=new ByteArrayInputStream(msg.getBytes());
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        int len=-1;
        while((len=inputStream.read())!=-1){
            outputStream.write(Character.toUpperCase(len));
        }
        //直接将内存输出流输出
        System.out.println(outputStream);
        //方法二：
        try(InputStream in = new ByteArrayInputStream(msg.getBytes());
            OutputStream out = new ByteArrayOutputStream()//默认构造方法缓存区32个字节
        ){
            byte[] buff=new byte[3];
            int count=0;
            while((len=in.read(buff))!=-1) {
                for (int i = 0; i < len; i++) {
                    byte b=buff[i];
                    if(b>='a'&&b<='z') {
                        count++;
                        buff[i] = (byte) (buff[i] - 32);
                    }
                }
                out.write(buff,0,len);
            }
            //OutputStream中没有toByteArray，当前情况下要使用必须向下转型
            byte[] newData= ((ByteArrayOutputStream) out).toByteArray();
            System.out.println(new String(newData));
            System.out.println("转换次数："+count);
        }catch (IOException e){

        }
    }
}
