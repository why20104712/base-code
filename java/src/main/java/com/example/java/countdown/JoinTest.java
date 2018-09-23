package com.example.java.countdown;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {

        ThreadDemo thread1 = new ThreadDemo(1);
        ThreadDemo thread2 = new ThreadDemo(2);
        thread1.start();
        thread1.join();
        log.warn("----");
        thread2.start();
        thread2.join();
        log.warn("main is end!");


    }
}


@Slf4j
class ThreadDemo extends Thread{
    
    private int number;
    public ThreadDemo(int number){
        this.number = number;
    }
    
    @Override
    public void run(){
        log.warn("Thread"+number+" is running");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.warn("Thread"+number+" is end");
    }
}