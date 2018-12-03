package com.qqy.exception;

import java.io.File;
import java.io.FileInputStream;

/**
 * 受查异常,必须处理
 * Author: qqy
 */
public class Test3 {
    public static void main(String[] args) {
        File file = new File("D:\\a.txt");
        try{
            FileInputStream inputStream=new FileInputStream(file);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
