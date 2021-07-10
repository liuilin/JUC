package com.liumulin;

/**
 * @author liuqiang
 * @since 2021-07-10
 */
public class LockSupportDemo {

    private static Object objLock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (objLock) {
                System.out.println(Thread.currentThread().getName() + "---come in");
                try {
                    objLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"---被唤醒");
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (objLock) {
                objLock.notify();
                System.out.println(Thread.currentThread().getName()+"---通知");
            }
        }, "B").start();
    }
}
