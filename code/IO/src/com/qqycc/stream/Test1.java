package com.qqycc.stream;

/**
 * 自动关闭
 * Author: qqy
 */
public class Test1 {
    public static void main(String[] args) {
        try(Msg msg=new Msg()){
            msg.print();  //normal method...   auto close...
        }catch (Exception e){

        }
    }
}

class Msg implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("auto close...");
    }

    public void print(){
        System.out.println("normal method...");
    }
}