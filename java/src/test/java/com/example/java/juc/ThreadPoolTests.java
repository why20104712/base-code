package com.example.java.juc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * 创建线程的第四种方式：线程池
 * @author wanghaiyang
 * @date 2018/9/21 11:16
 */
@Slf4j
public class ThreadPoolTests {


    /**
     * 固定大小线程池
     */
    @Test
    public void test1() throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        //创建固定大小的线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);

        Integer result = 0;

        for (int i = 0; i < 10; i++) {
            //为线程分配任务
            result += pool.submit(() -> {
                log.warn("当前线程：{}", Thread.currentThread().getName());
                return 1;
            }).get();
        }

        log.warn("线程执行结果：{}", result);

        //关闭线程池,会等待所有线程结束才关闭
        pool.shutdown();

        long end = System.currentTimeMillis();
        log.warn("程序执行耗时：{}", end - start);
    }

    /**
     * 动态大小线程池
     */
    @Test
    public void test2() throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        //创建动态大小的线程池
        ExecutorService pool = Executors.newCachedThreadPool();

        Integer result = 0;

        for (int i = 0; i < 10; i++) {
            result += pool.submit(() -> {
                log.warn("当前线程：{}", Thread.currentThread().getName());
                return 1;
            }).get();
        }
        log.warn("线程执行结果：{}", result);

        //关闭线程池,会等待所有线程结束才关闭
        pool.shutdown();
        long end = System.currentTimeMillis();
        log.warn("程序执行耗时：{}", end - start);
    }


    /**
     * 有调度功能的线程池
     */
    @Test
    public void test3() throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        //创建调度功能的线程池
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);

        Integer result = 0;

        for (int i = 0; i < 10; i++) {
            result += pool.schedule(() -> {
                log.warn("当前线程：{}", Thread.currentThread().getName());
                return 1;
            }, 1000, TimeUnit.MILLISECONDS).get();
        }
        log.warn("线程执行结果：{}", result);

        //关闭线程池,会等待所有线程结束才关闭
        pool.shutdown();
        long end = System.currentTimeMillis();
        log.warn("程序执行耗时：{}", end - start);
    }


}
