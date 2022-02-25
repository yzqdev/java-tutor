package com.yzq.thread.concurrent;

import org.junit.jupiter.api.Test;

/**java有两个默认线程
 * main线程和gc线程
 * <p>
 *     java其实并不能启动线程,他是通过native方法启动的,(运行中jvm上)
 * </p>
 * @author yanni
 * @date time 2022/1/26 12:37
 * @modified By:
 */
public class JucTest {
    @Test
    public void getCpu(){
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
    @Test
    public void threadStates(){
        for(Thread.State state: Thread.State.values()){
            System.out.println(state);
        }

    }
}
