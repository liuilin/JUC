package com.liumulin.lock;

/**
 * 可重入锁:可重复可递归调用的锁，在外层使用锁之后，在内层仍然可以使用，并且不发生死锁，这样的锁就叫做可重入锁
 * <p>
 * 在一个synchronized修饰的方法或代码块的内部
 * <p>
 * 调用本类的其他synchronized修饰的方法或代码块时，是永远可以得到锁的
 *
 * @author liuqiang
 * @since 2021-07-10
 */
public class SynchronizeLockWithBlock {

    private static Object objLock = new Object();

    public static void main(String[] args) {
        m1();
    }

    public static void m1() {
        new Thread(() -> {
            synchronized (objLock) {
                System.out.println(Thread.currentThread().getName() + "---outside invoke");
                synchronized (objLock) {
                    System.out.println(Thread.currentThread().getName() + "---middle invoke");
                    synchronized (objLock) {
                        System.out.println(Thread.currentThread().getName() + "---inside invoke");
                    }
                }
            }
        }, "t1").start();
    }
}
