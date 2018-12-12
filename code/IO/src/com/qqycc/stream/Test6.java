package com.qqycc.stream;

import java.io.*;
import java.nio.file.Paths;

/**
 * 文件复制
 * Author: qqy
 */
public class Test6 {
    public static void main(String[] args) throws IOException {
        String src="";
        String dest="";
        long start=System.currentTimeMillis(); //毫秒数
        copy(src,dest);
        long end=System.currentTimeMillis();
        System.out.println(end-start/1000+"s");  //秒数
    }

    public static void copy(String srcFilePath,String destFilePath){
        //参数校验
        if (srcFilePath==null||srcFilePath.isEmpty()) {
            throw new IllegalArgumentException("srcFilePath not null/empty!");
        }
        if (destFilePath==null||destFilePath.isEmpty()) {
            throw new IllegalArgumentException("destFilePath not null/empty!");
        }

        File srcFile =Paths.get(srcFilePath).toFile();
        File destFile =Paths.get(destFilePath).toFile();
        //文件校验以及准备工作
        if(!srcFile.exists()||!srcFile.isFile()){
            throw new IllegalArgumentException("srcFilePath not exists or not file!");
        }

        File parentFile= destFile.getParentFile();
        if(!parentFile.exists()){
            if(!parentFile.mkdirs()){
                throw new RuntimeException("can't create"+parentFile.getAbsolutePath()+"directory");
            }
        }

        //文件复制
        try(FileInputStream in=new FileInputStream(srcFile);
            FileOutputStream out =new FileOutputStream(destFile)
        ){
          //缓冲数组
          byte[] buff = new byte[1024];  //1k,2k,4k,8k
          int len=-1;
          while((len=in.read(buff))!=-1){
              out.write(buff,0,len);
          }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
