package com.example.java.lamada;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;


public class LamadaTest {


    @Test
    public void test1() {

        //匿名内部类（策略模式）
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("run-------");
            }
        };
        r.run();


        //lamada表达式
        Runnable r1 = () -> System.out.println("run1-------");
        r1.run();

    }

    @Test
    public void test2() {

        //匿名内部类作为参数传递
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        //lamada表达式
        TreeSet<String> treeSet1 = new TreeSet<>((o1, o2) -> o1.compareTo(o2));

    }


    @Test
    public void test3() {
        //优化方式一：策略设计模式
        //优化方式二：匿名内部类
        //优化方式三：Lambda 表达式
        //优化方式四：Stream API
    }

}
