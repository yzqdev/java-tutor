package com.yzq.thread;

import org.junit.jupiter.api.Test;

/**
 * @author yanni
 * @date time 2022/1/25 4:49
 * @modified By:
 */
public class ForTest {
    @Test
    public void for1(){

        var a=111;
        var b=a++;
        System.out.println(b + " " + a);
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
