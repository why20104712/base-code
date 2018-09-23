package com.example.java.threadlocal;


/**
 * threadlocal设计的目的是：为了能够在当前线程有属于自己的变量，并不是为了解决并发或者共享变量的问题，实现了线程数据的隔离
 * @author wanghaiyang
 * @date 2018/9/23 21:11
 */
public class ThreadLocalTest {

    /**
     * ThreadLocal 变量通常被private static修饰。当一个线程结束时，它所使用的所有 ThreadLocal 相对的实例副本都可被回收
     */
    private static final ThreadLocal<Object> threadLocal = new ThreadLocal<Object>() {
        /**
         * ThreadLocal没有被当前线程赋值时或当前线程刚调用remove方法后调用get方法，返回此方法值
         */
        @Override
        protected Object initialValue() {
            System.out.println("调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！");
            return null;
        }
    };

    public static void main(String[] args) {
        new Thread(new MyIntegerTask("IntegerTask1")).start();
        new Thread(new MyIntegerTask("IntegerTask2")).start();
        new Thread(new MyStringTask("StringTask1")).start();
        new Thread(new MyStringTask("StringTask2")).start();
    }

    public static class MyIntegerTask implements Runnable {
        private String name;

        MyIntegerTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                // ThreadLocal.ThreadLocalTest
                if (null == ThreadLocalTest.threadLocal.get()) {
                    // ThreadLocal.et方法设置线程变量
                    ThreadLocalTest.threadLocal.set(0);
                    System.out.println("线程" + name + ": 0");
                } else {
                    int num = (Integer) ThreadLocalTest.threadLocal.get();
                    ThreadLocalTest.threadLocal.set(num + 1);
                    System.out.println("线程" + name + ": " + ThreadLocalTest.threadLocal.get());
                    if (i == 3) {
                        ThreadLocalTest.threadLocal.remove();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static class MyStringTask implements Runnable {
        private String name;

        MyStringTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                if (null == ThreadLocalTest.threadLocal.get()) {
                    ThreadLocalTest.threadLocal.set("a");
                    System.out.println("线程" + name + ": a");
                } else {
                    String str = (String) ThreadLocalTest.threadLocal.get();
                    ThreadLocalTest.threadLocal.set(str + "a");
                    System.out.println("线程" + name + ": " + ThreadLocalTest.threadLocal.get());
                }
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}