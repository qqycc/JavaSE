package com.qqycc.file;

import java.io.File;
import java.io.IOException;

/**
 * 目录操作
 * Author: qqy
 */
public class Test3 {
    public static void main(String[] args) {
        File file = new File("E:" + File.separator + "a" + File.separator + "help.txt");
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                if (parentFile.mkdirs()) {
                    System.out.println("创建目录成功");
                }
            }
            try {
                if (file.createNewFile()) {
                    System.out.println("创建文件成功");
                } else {
                    System.out.println("创建文件失败");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

