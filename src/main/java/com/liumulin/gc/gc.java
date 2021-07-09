package com.liumulin.gc;

import java.util.Random;

/**
 * @author Mugen 2019/2/25
 */
public class gc {

    public static void main(String[] args) {
        //Metaspace 元数据区
        /*
         * 16G
         * -Xmx1024m -Xms1024m -XX:+PrintGCDetails
         * 需要将jvm内存固定为 3/4
         * */
        //返回Java虚拟机试图使用最大内存量1/4
        long maxMemory = Runtime.getRuntime().maxMemory();
        //返回Java虚拟机中的内存量1/64
        long totalMemory = Runtime.getRuntime().totalMemory();

        System.out.println("MAX_MEMORY = " + maxMemory);
        System.out.println("TOTAL_MEMORY = " + totalMemory);

        String str = "Gakki";
        while (true) {
            //不停产生垃圾
            str += str + new Random().nextInt(8888888) + new Random().nextInt(88888888);
        }
    }
}