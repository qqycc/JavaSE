package com.qqycc.file;

import java.io.File;
import java.io.IOException;

/**
 * File类的基本使用
 * Author: qqy
 */
public class Test1 {
    public static void main(String[] args) {
        //取得File对象
        //E:\help.txt
        File file=new File("E:"+File.separator+"help.txt");
        //判断文件是否存在
            if (file.exists()) {
                if (file.delete()){
                    System.out.println("文件存在，删除成功");
                }else{
                    System.out.println("文件存在，删除失败");
                }
            }else{
                try{
                    // //file.createNewFile()返回值是boolean类型
                    //File类只是创建文件本身，但是对于其内容并不做处理
                    if(file.createNewFile()){
                        System.out.println("文件不存在，创建成功");
                    }else{
                        System.out.println("文件不存在，创建失败");
                    }
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
    }
}
