package com.example.java.lamada;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 方法引用测试
 * @author wanghaiyang
 * @date 2018/7/20 21:10
 */
public class MethodRef {



    /*
     * Java8 内置的四大核心函数式接口
     *
     * Consumer<T> : 消费型接口
     * 		void accept(T t);
     *
     * Supplier<T> : 供给型接口
     * 		T get();
     *
     * Function<T, R> : 函数型接口
     * 		R apply(T t);
     *
     * Predicate<T> : 断言型接口
     * 		boolean test(T t);
     *
     */

    /*
     * 一、方法引用：若 Lambda 体中的功能，已经有方法提供了实现，可以使用方法引用
     * 			  （可以将方法引用理解为 Lambda 表达式的另外一种表现形式）
     *
     * 1. 对象的引用 :: 实例方法名
     *
     * 2. 类名 :: 静态方法名
     *
     * 3. 类名 :: 实例方法名
     *
     * 注意：
     * 	 ①方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
     * 	 ②若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，格式： ClassName::MethodName
     *
     * 二、构造器引用 :构造器的参数列表，需要与函数式接口中参数列表保持一致！
     *
     * 1. 类名 :: new
     *
     * 三、数组引用
     *
     * 	类型[] :: new;
     *
     *
     */

    @Test
    public void test1() {

        Function<String, Integer> f = (a) -> Integer.valueOf(a);
        f.apply("12");

        Consumer<String> consumer = System.out::println;
        consumer.accept("aaaaaaaa");

        Supplier<String> supplier = () -> "sddddd";
        supplier.get();

        Predicate<String> predicate = (a) -> a.contains("a");
        predicate.test("aaaa");

    }


}
