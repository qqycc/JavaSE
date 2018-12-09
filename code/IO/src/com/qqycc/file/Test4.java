package com.qqycc.file;

import java.io.File;
import java.util.Date;

/**
 * 文件信息
 * Author: qqy
 */
public class Test4 {
    public static void main(String[] args) {
        File file = new File("E:" + File.separator + "JAVA" + File.separator + "JavaSE");
        System.out.println("文件是否是目录："+file.isDirectory());
        System.out.println("文件是否是普通文件："+file.isFile());
        //通过文件调用，不能获取目录的大小
        System.out.println("文件大小："+file.length());
        System.out.println("文件最后修改时间："+new Date(file.lastModified()));
    }
}
