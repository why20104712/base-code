package com.example.java.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleDateFormatTest {


    /**
     * 测试SimpleDateFormat线程不安全
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        //线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //带返回值的任务
        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return simpleDateFormat.parse("20190808");
            }
        };

        //返回结果集合
        List<Future<Date>> futures = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Future<Date> future = executorService.submit(task);
            futures.add(future);
        }

        for (Future<Date> dateFuture : futures) {
            System.out.println(dateFuture.get());
        }

        //关闭线程池
        executorService.shutdown();


    }


    /**
     * 使用threadLocal构建线程安全的SimpleDateFormat
     *
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {

        //线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //带返回值的任务
        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return DateFormatThreadLocal.parse("20180909");
            }
        };

        //返回结果集合
        List<Future<Date>> futures = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Future<Date> future = executorService.submit(task);
            futures.add(future);
        }

        for (Future<Date> dateFuture : futures) {
            System.out.println(dateFuture.get());
        }

        //关闭线程池
        executorService.shutdown();

    }

    /**
     * 使用java8新增的api LocalDate 线程安全的
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        //线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //带返回值的任务
        Callable<LocalDate> task = () -> LocalDate.parse("20180909", dateTimeFormatter);

        //返回结果集合
        List<Future<LocalDate>> futures = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Future<LocalDate> future = executorService.submit(task);
            futures.add(future);
        }

        for (Future<LocalDate> dateFuture : futures) {
            System.out.println(dateFuture.get());
        }

        //关闭线程池
        executorService.shutdown();

    }
}
