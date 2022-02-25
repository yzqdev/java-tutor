package com.yzq.thread;

import org.junit.jupiter.api.Test;

public class ThreadRandomDemo1 {

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new RandomThread("RandomThread:" + i);
        }
        for(Thread thread : threads) {
            thread.start();
        }
    }
}

class RandomThread extends Thread {
    
    public RandomThread(String name) {
        super(name);
    }
    
    @Override
    public void run() {

        try {
            Thread.sleep(1000);
            System.out.println( Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
