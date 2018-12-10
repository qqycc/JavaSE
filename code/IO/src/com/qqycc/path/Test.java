package com.qqycc.path;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Author: qqy
 */
public class Test {
    public static void main(String[] args) {
        //Path是接口，无法实例化对象，借助辅助类Paths来实现
        //E:\JAVA
        Path path=Paths.get("E","JAVA");
        //E:\JAVA\code
        Path path1=Paths.get("E","help");
        //E:
        Path path2=Paths.get("E");
        //将Path对象转换为File对象
        File file=path.toFile();
        File file1=Paths.get("E").toFile();

        try {
            Files.deleteIfExists(path1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
