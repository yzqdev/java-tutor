package com.yzq.thread;

public class ThreadVariableStopDemo {
    public static void main(String[] args) throws InterruptedException {
        VariableStopThread thread = new VariableStopThread("thread_1");
        thread.start();
        Thread.sleep(3);
        thread.Stop();
    }
}

class VariableStopThread extends Thread {
    private boolean interrupt = true;
    
    public VariableStopThread(String name) {
        super(name);
    }
    
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":线程开始运行!");
        int i = 0;
        while(interrupt) {
            System.out.println("" + (i++));
        }
        System.out.println("我停止了! timer:" + System.currentTimeMillis());
    }
    
    public void Stop() {
        System.out.println(Thread.currentThread().getName() + ":线程设置了停止! timer:" + System.currentTimeMillis());
        this.interrupt = false;
    }
}
