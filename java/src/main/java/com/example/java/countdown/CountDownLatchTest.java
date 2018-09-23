package com.example.java.countdown;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;


@Slf4j
public class CountDownLatchTest {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        long start = System.currentTimeMillis();
        new Thread(){
            public void run() {
                try {
                    log.warn("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    log.warn("子线程"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        new Thread(){
            public void run() {
                try {
                    log.warn("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    log.warn("子线程"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        try {
            log.warn("等待2个子线程执行完毕...");
            latch.await();
            log.warn("2个子线程已经执行完毕");
            log.warn("继续执行主线程");
            long end = System.currentTimeMillis();
            log.warn("程序执行耗时：{}", end - start);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

