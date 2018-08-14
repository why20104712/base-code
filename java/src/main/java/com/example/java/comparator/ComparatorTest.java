package com.example.java.comparator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorTest {

    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        list.add(new Person("zhang", 22, 9));
        list.add(new Person("li", 80, 8));
        list.add(new Person("huang", 31, 7));
        list.add(new Person("bai", 8, 6));
        list.add(new Person("wei", 57, 5));
        list.add(new Person("huang", 31, 9));
//        Collections.sort(list);

        List<Person> collect = list.stream().sorted().collect(Collectors.toList());

        System.out.println(collect);
    }


}
