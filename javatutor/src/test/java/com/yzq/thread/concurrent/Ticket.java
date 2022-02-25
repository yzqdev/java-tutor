package com.yzq.thread.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yanni
 * @date time 2022/1/26 12:51
 * @modified By:
 */
enum TicketStatus {
    SYNC,
    LOCK
}

public class Ticket {
    private int number = 50;
    Lock lock = new ReentrantLock(true);

    public void sale(TicketStatus status) {
        switch (status) {
            case SYNC:
                syncSale();
                break;
            case LOCK:
                lockSale();
                break;
            default:
                break;
        }
    }

    public void syncSale() {
        lock.lock();
        try {
            saleFun();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void saleFun() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了第" + number + "张票" + ",剩余" + (number--) + "张票");
        }
    }

    public void lockSale() {
        lock.lock();
        try {
            saleFun();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
