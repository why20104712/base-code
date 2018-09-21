package com.example.spring.bean;

import lombok.Data;

@Data
public class Person {

    private String name;

    private Integer age;

    private String phone;


    public void init() {
        this.name = "name";
        this.age = 20;
        this.phone = "15656236536";
    }
}
