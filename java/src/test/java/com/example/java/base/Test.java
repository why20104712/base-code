package com.example.java.base;


import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;

public class Test {


    @org.junit.Test
    public void test() {

        System.out.println(NumberUtils.toInt("100.0"));

//        System.out.println(Integer.valueOf("100.0"));

        System.out.println(BigDecimal.valueOf(Double.valueOf("100.231")).toBigInteger().intValue());

        System.out.println(Double.valueOf("100.0"));


    }
}
