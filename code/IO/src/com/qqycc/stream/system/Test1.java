package com.qqycc.stream.system;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author: qqy
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        InputStream in=System.in;
        byte[] data=new byte[1024];
        System.out.println("请输入内容：");
        int temp=in.read(data);
        System.out.println("请输入内容："+new String(data,0,temp));
    }
}
