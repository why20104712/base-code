package com.example.java.comparator;

import lombok.Data;

@Data
public class Person implements Comparable<Person>{

    private String name;

    private Integer age;

    private Integer price;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, int price) {
        this.name = name;
        this.age = age;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Person[name = " + name + ",age = " + age + " price = " + price + "]";
    }

    @Override
    public int compareTo(Person person) {
        return  person.getAge() - this.getAge();
    }
}
