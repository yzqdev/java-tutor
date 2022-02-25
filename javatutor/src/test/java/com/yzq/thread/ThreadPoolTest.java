package com.yzq.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池测试
 *
 * @author yanni
 * @date time 2021/10/14 14:33
 * @modified By:
 */
public class ThreadPoolTest {

    // 线程数
    public static final int THREAD_POOL_SIZE = 16;

    @Test
    void pool() throws InterruptedException {
        // 使用 ThreadFactoryBuilder 创建自定义线程名称的 ThreadFactory
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("hyn-demo-pool-%d").build();

        // 创建线程池，其中任务队列需要结合实际情况设置合理的容量
        ThreadPoolExecutor executor = new ThreadPoolExecutor(THREAD_POOL_SIZE,
                THREAD_POOL_SIZE,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024),
                namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());

        // 新建 1000 个任务，每个任务是打印当前线程名称
        int num = 1000;
        for (int i = 0; i < num; i++) {
            executor.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        // 优雅关闭线程池
        executor.shutdown();
        executor.awaitTermination(1000L, TimeUnit.SECONDS);
        // 任务执行完毕后打印"Done"
        System.out.println("Done");
    }
}
