package com.qqycc.file;

import java.io.File;

/**
 * 列出目录中的全部组成
 * Author: qqy
 */
public class Test5 {
    public static void main(String[] args) {
        File file = new File("E:" + File.separator + "JAVA" + File.separator + "JavaSE");
        File[] files=file.listFiles();
        String[] fileName=file.list();
        //if(file.exists()&&file.isDirectory())
        if(files!=null) {
            for (File f : files) {
                System.out.println(f.getName());
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}
