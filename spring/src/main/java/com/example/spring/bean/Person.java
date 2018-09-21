package com.example.spring.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Person {

    private String name;

    private Integer age;

    private String phone;


    public void init() {
        this.name = "name";
        this.age = 20;
        this.phone = "15656236536";

        log.warn("调用person初始化init======");
    }

    public Person() {
        log.warn("调用person无参数构造器");
    }

}
