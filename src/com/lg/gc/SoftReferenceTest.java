package com.lg.gc;

import java.lang.ref.SoftReference;

/**
 * @author Mugen 2019/2/25
 */
public class SoftReferenceTest {

    public static void main(String[] args){
        System.out.println("haha");
        SoftReference<Person>[] person = new SoftReference[100000];
        for (int i = 0; i < person.length; i++) {
            person[i] = new SoftReference<Person>(new Person("name:" + i,i));
        }
        System.out.println(person[1].get());
        System.out.println(person[2].get());

    }
}