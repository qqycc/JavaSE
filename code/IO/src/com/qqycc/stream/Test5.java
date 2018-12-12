package com.qqycc.stream;

import java.io.*;
import java.nio.file.Paths;

/**
 * 将一个文件的内容写入到另一个文件
 * Author: qqy
 */
public class Test5 {
    public static void main(String[] args) {
        File file=Paths.get("E:","JAVA","TestSerializable.txt").toFile();
        File file1=Paths.get("E:","JAVA","Test1.txt").toFile();
        try(FileInputStream in = new FileInputStream(file);
            FileOutputStream out = new FileOutputStream(file1)
        ){
            byte[] buff=new byte[3];
            int len;
            while((len=in.read(buff))!=-1){
                //为了避免数据读取不全，使用下列方式进行写入
                out.write(buff,0,len);
            }
        }catch(IOException e){

        }
    }
}

