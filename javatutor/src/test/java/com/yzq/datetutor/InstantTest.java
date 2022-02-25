package com.yzq.datetutor;

import org.junit.jupiter.api.Test;

import java.time.Instant;

/**
 * @author yanni
 * @date time 2022/1/21 22:52
 * @modified By:
 */
public class InstantTest {
    @Test
    public void instant() {
        Instant now = Instant.now();
        System.out.println(System.currentTimeMillis());
        System.out.println(now.getEpochSecond()); // 秒
        System.out.println(now.toEpochMilli()); // 毫秒
    }
}
