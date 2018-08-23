package com.example.java.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子性操作
 * @author wanghaiyang
 * @date 2018/8/23 12:52
 */
public class Atomic {

    public static void main(String[] args) {
        AtomicTest atomicTest = new AtomicTest();

        for (int i = 0; i < 10; i++) {
            new Thread(atomicTest).start();
        }
    }
}


class AtomicTest implements Runnable{

//    private Integer index = 0;

    private AtomicInteger index = new AtomicInteger(1);

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        index++;

        System.out.println(getIndex());
    }

    public Integer getIndex() {
        return index.getAndIncrement();
    }
}