package com.qqycc.file;

import java.io.File;
import java.io.IOException;

/**
 *
 * Author: qqy
 */
public class Test {
    public static void main(String[] args) {
        //取得File对象
        File file=new File("E:\\help.txt");
        //file.createNewFile()返回值是boolean类型
        try {
            if (file.createNewFile()) {
                System.out.println("创建文件成功");
            } else {
                System.out.println("创建文件失败");
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
