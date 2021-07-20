package com.liumulin.lock;

import java.util.ArrayList;

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
public class SynchronizedLockWithMethod {

    public static void main(String[] args) {
        new SynchronizedLockWithMethod().m1();
    }

    private synchronized void m1() {
        System.out.println("---outside");
        m2();
    }

    private synchronized void m2() {
        System.out.println("---middle");
        m3();
    }

    private synchronized void m3() {
        System.out.println("---inside");
    }
}
