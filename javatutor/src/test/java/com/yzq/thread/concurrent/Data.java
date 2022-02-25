package com.yzq.thread.concurrent;

/**
 * @author yanni
 * @date time 2022/1/26 14:02
 * @modified By:
 */
public class Data {
    private int number=0;
    public synchronized  void increase() throws InterruptedException {
        if (number!=0){
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+" increament to "+number);
        this.notifyAll();
    }
    public synchronized void decrement() throws InterruptedException {
        if (number==0){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+" decrement to "+number);
        this.notifyAll();
    }
}
