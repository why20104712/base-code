package com.example.demo.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Person {

    private Integer id;

    private String name;

    private Integer age;

    private String email;

    private Date birthday;

    private Boolean del;
}
