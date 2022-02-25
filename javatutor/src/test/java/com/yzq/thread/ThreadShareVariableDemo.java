package com.yzq.thread;

public class ThreadShareVariableDemo {
    public static void main(String[] args) {
        TicketThread t1 = new TicketThread();
        new Thread(t1, "小明").start();
        new Thread(t1, "小红").start();
        new Thread(t1, "小芳").start();
        new Thread(t1, "小刚").start();
    }
}

class TicketThread implements Runnable {
    private int ticketNum = 10;

    /**
     * 这里解释一下synchronized关键字，含有synchronized关键字的这个方法称为“互斥区” 或“临界区”，只有获得这个关键字对应的锁才能执行方法体，方法体执行完自动会释放锁。
     */
    public synchronized   void  run() {
        while (true){
            if (ticketNum < 0) {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("" + Thread.currentThread().getName() + "抢到了第" + ticketNum--+"张票");
        }
    }
}
