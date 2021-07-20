package com.liumulin.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuqiang
 * @since 2021-07-10
 */
public class LockSupportDemo {

    private static Object objLock = new Object();
    private static ReentrantLock rLock = new ReentrantLock();
    private static Condition condition = rLock.newCondition();

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            //暂停一会儿线程
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + "---come in");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "---被唤醒");
        }, "A");
        a.start();

        //暂停一会儿线程
//        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        Thread b = new Thread(() -> {
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + "---被通知");
        }, "B");
        b.start();
    }

    private static void conditionAwaitSignal() {
        new Thread(() -> {
            rLock.lock();
            try {
                try {
                    System.out.println(Thread.currentThread().getName() + "---come in");
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                rLock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "---被唤醒");
        }, "A").start();

        new Thread(() -> {
            rLock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "---通知");
            } finally {
                rLock.unlock();
            }
        }, "B").start();
    }

    private static void synchronizedWaitNotify() {
        new Thread(() -> {
            //暂停一会儿线程
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (objLock) {
                System.out.println(Thread.currentThread().getName() + "---come in");
                try {
                    objLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "---被唤醒");
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (objLock) {
                objLock.notify();
                System.out.println(Thread.currentThread().getName() + "---通知");
            }
        }, "B").start();
    }
}
