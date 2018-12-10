package com.qqycc.file;

import java.io.File;

/**
 * 综合案例
 * Author: qqy
 */
public class Test6 {
    public static void main(String[] args) {
        File file = new File("E:" + File.separator + "JAVA" + File.separator + "JavaSE");
        new Thread(new Runnable() {
            @Override
            public void run() {
                findFile(file, 0);
            }
        }).start();
        System.out.println("hello");
    }

    //通过递归方式遍历指定文件目录下的所有文件及子目录
    public static void findFile(File file, int level) {
        if (file.isFile()) {
            System.out.println("|" + repeatSpace(level) + "|-" + file.getName());
        } else {
            System.out.println(repeatSpace(level) + "+" + file.getName());
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    findFile(f, level + 2);
                }
            }
        }
    }

    public static String repeatSpace(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
