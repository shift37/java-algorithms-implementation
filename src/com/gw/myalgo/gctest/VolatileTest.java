package com.gw.myalgo.gctest;

import java.util.concurrent.atomic.AtomicInteger;


public class VolatileTest {
    public static AtomicInteger t = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        int tnum = 10;
        Thread[] threads = new Thread[tnum];
        for(int i = 0; i < tnum; i++){
            //每个线程对t进行1000次加1的操作
            threads[i] = new Thread(() -> {
                for(int j = 0; j < 1000; j++){
                    t.incrementAndGet();
                }
                System.out.println(Thread.currentThread().getName() + " is over");
            });
            threads[i].start();
        }

        Thread.sleep(1000);

        //打印t的值
        System.out.println(t);
    }
}

