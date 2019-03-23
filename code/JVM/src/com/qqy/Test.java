package com.qqy;

/**
 * finalize()
 * Author:qqy
 */
public class Test {
    //test默认值为null
    public static Test test;

    public void isLive(){
        System.out.println("Test对象活着");
    }

    //Object中的finalize()什么都没做，覆写
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("执行了Test的finalize()");
        test=this;
    }

    public static void main(String[] args) {
        test=new Test();  //test是引用关系，无法被回收 test!=null
        test=null;
        //gc执行，发现test没有被引用，应该被回收
        //但是回收时，发现finalize()被覆写了，gc就会执行finalize()
        //在finalize()中又把当前对象赋给test对象，这时候test就活了
        System.gc();

        try {
            //gc()是守护线程，调用时能否立即执行无法确定
            //刚一gc()就走下一步，线程可能还没有执行
            //若执行较晚，test肯定为null
            //因此，调用sleep()阻塞,预估1s后能gc
            //gc后，test就活了，就不等于null
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(test!=null){
            test.isLive();
        }else {
            System.out.println("Test对象已死");
        }

        //免死一次后，再死一次
        test=null;
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(test!=null){
            test.isLive();
        }else {
            System.out.println("Test对象已死");
        }
    }
}
