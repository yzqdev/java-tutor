package com.yzq.thread;

import org.junit.jupiter.api.Test;

/**
 * 通过实现 Runnable 接口；<br>
 * 通过继承 Thread 类本身；<br>
 * 通过 Callable 和 Future 创建线程。
 */
  class ExtendThreadTest {
    @Test
    void myThread() {
        Thread t = new MyThread();
        t.start();
        try {
            Thread.sleep(1000);
            t.interrupt(); // 中断t线程
            t.join(); // 等待t线程结束
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        Thread hello = new HelloThread();
        hello.start(); // 启动hello线程
        try {
            hello.join(); // 等待hello线程结束
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }
        hello.interrupt();
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
