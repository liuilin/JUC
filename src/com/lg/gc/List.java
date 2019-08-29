package com.lg.gc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 如何正确的将数组转换为ArrayList?
 *
 * @author Daniel Liu 2019/7/2 19:52
 */
public class List {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        System.out.println(list);

        //必须传一个对象，而非int数组（推荐java8的stream方式）
        System.out.println(Arrays.stream(new Integer[]{1, 2, 3}).collect(Collectors.toList()));
        System.out.println("hhh,submittttt");
    }
}