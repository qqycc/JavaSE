package com.qqycc.stream;

import java.io.*;

/**
 * 字节输出流
 * Author: qqy
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //1.取得终端对象
        File file = new File("E:"+File.separator+"JAVA"+File.separator+"TestSerializable.txt");
        //只要文件父路径存在，FileOutputStream会自动创建文件
        //OutputStream为抽象方法，需要借用子类进行实例化
        OutputStream out =null;
        OutputStream out1 =null;
        //2.取得终端对象的输出流
        try {
            out = new FileOutputStream(file);
            //允许内容的追加
            out1 = new FileOutputStream(file,true);
            //3.进行数据的输出
            String msg="你好世界！！！\r\n";
            //当出现中文时，最好全部输出，避免出现乱码
            out.write(msg.getBytes(),0,6);
            out1.write(97); //a
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            //4.关闭流
            out.close();
            out1.close();
        }
    }
}
