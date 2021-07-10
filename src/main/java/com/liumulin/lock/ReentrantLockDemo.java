package com.liumulin.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁:可重复可递归调用的锁，在外层使用锁之后，在内层仍然可以使用，并且不发生死锁，这样的锁就叫做可重入锁。
 * <p>
 * 在一个synchronized修饰的方法或代码块的内部
 * <p>
 * 调用本类的其他synchronized修饰的方法或代码块时，是永远可以得到锁的
 *
 * @author liuqiang
 * @since 2021-07-10
 */
public class ReentrantLockDemo {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("---outside");
                lock.lock();
                try {
                    System.out.println("---middle");
                    lock.lock();
                    try {
                        System.out.println("---inside");
                    } finally {
                        lock.unlock();
                    }
                } finally {
                    lock.unlock();
                }
            } finally {
                lock.unlock();
            }

        }, "t1").start();
    }

}
