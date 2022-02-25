package com.yzq.thread.concurrent;

import org.junit.jupiter.api.Test;

/**
 * @author yanni
 * @date time 2022/1/26 12:51
 * @modified By:
 */
public class SaleTicket {
    @Test
    public void mainSale() {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                ticket.syncSale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                ticket.syncSale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                ticket.syncSale();
            }
        }, "C").start();
    }

    @Test
    public void secondSale() {
        Data data = new Data();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "a").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "b").start();
    }
}
