package com.qqy.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 利用AQS实现一个锁
 * Author: qqy
 */
public class Test1 {
    public static void main(String[] args) {
        Lock lock=new Mutex();
        for (int i=0;i<10;i++){
            Thread thread=new Thread(()->{
                try{
                    lock.lock();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }finally {
                    lock.unlock();
                }
            });
            thread.start();
        }
    }
}

//自定义锁->实现Lock接口
class Mutex implements Lock {
    private Sync sync=new Sync();

    // 锁的实现利用AQS
    // 自定义同步器(静态内部类)
    static class Sync extends AbstractQueuedSynchronizer{

        //独占式获取锁
        @Override
        protected boolean tryAcquire(int arg) {
            if(arg!=1){
                throw new RuntimeException("arg参数不为1");
            }
            if(compareAndSetState(0,1)){
                //更新为1，此时线程成功获取同步状态
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        //独占式释放锁
        @Override
        protected boolean tryRelease(int arg) {
            if (getState()==0){
                throw new IllegalArgumentException();
            }
            //释放
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        //当前线程是否获取到同步状态
        @Override
        protected boolean isHeldExclusively() {
            return getState()==1;
        }
    }

    //--------------------------------------------------------------
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,time);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
    //--------------------------------------------------------------
}

