package com.lg.gc;

import java.util.Arrays;

/**
 * test
 *
 * @author Daniel Liu 2019/7/2 15:53
 */
public class test {
    public static void main(String[] args) {
        String str = "GB 2762-2017《食品安全国家标准 食品中污染物限量》";
        System.out.println(Arrays.toString(new String[]{str.split("《")[1].replace("》","")}));
        System.out.println("1111");
    }
}