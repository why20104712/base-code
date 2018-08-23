package com.example.java.concurrent;

/**
 * 内存可见性
 * @author wanghaiyang
 * @date 2018/8/23 12:42
 */
public class MemeoryVisual {

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        new Thread(threadTest).start();
        while (Boolean.TRUE) {
            if (threadTest.getFlag()) {
                System.out.println(Thread.currentThread().getName() + ": Main线程");
                break;
            }
        }

    }
}


class ThreadTest implements Runnable{

    private volatile Boolean flag = Boolean.FALSE;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = Boolean.TRUE;
        System.out.println(Thread.currentThread().getName() + ":" + flag);
    }

    public Boolean getFlag() {
        return flag;
    }
}
