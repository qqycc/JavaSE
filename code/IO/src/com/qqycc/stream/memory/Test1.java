package com.qqycc.stream.memory;

import java.io.*;
import java.nio.file.Paths;

/**
 * 内存流合并两个文件
 * Author: qqy
 */
public class Test1 {
    public static void main(String[] args) {
        File file1=Paths.get("E:","JAVA","TestSerializable.txt").toFile();
        mergeFileBetter(new String[]{
                "E:"+File.separator+"JAVA"+File.separator+"TestSerializable.txt",
                "E:"+File.separator+"JAVA"+File.separator+"Test1.txt"
        },"E:"+File.separator+"JAVA"+File.separator+"destTest.txt");
    }

    public static void mergeFileBetter(String[] mergePaths,String outPaths){
        //参数校验
        File[] files=new File[mergePaths.length];
        //初始化所有输入文件
        for(int i=0;i<mergePaths.length;i++){
            files[i]=new File(mergePaths[i]);
        }
        //输出流
        try(ByteArrayOutputStream memoryOut=new ByteArrayOutputStream();
            FileOutputStream out=new FileOutputStream(outPaths)
        ) {
            //遍历合并的文件，输入到内存流
            for (File f : files) {
                try (FileInputStream in = new FileInputStream(f)) {
                    //读文件并写入内存流
                    byte[] buff=new byte[3];
                    int len=-1;
                    while((len=in.read(buff))!=-1){
                        memoryOut.write(buff,0,len);
                    }
                } catch (IOException e) {

                }
            }
            //内存流输出到文件
            out.write(memoryOut.toByteArray());
        }catch (IOException e){

        }
    }
}
