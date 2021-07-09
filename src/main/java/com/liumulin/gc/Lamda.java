package com.liumulin.gc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Daniel Liu 2019/6/28 15:43
 */
public class Lamda {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>(3);
        persons.add(new Person("Gakki", 18));
        persons.add(new Person("Fuu", 17));
//        ArrayList<Person> persons = new ArrayList<>(Arrays.asList(new Person("Mugen", 20), new Person("Jin", 20)));

//        List<String> names = persons.stream().map(person -> person.getName()).collect(Collectors.toList());
        List<String> names = persons.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(names);


        Integer[] myArray = {1, 2, 3};
        System.out.println(Arrays.stream(myArray).filter(integer -> integer > 2).collect(Collectors.toList()));
    }
}