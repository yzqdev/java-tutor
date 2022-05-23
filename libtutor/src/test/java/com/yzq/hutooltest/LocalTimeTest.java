package com.yzq.hutooltest;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import cn.hutool.core.thread.ThreadUtil;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

/**
 * @author yanni
 * @date time 2022/5/24 6:38
 * @modified By:
 */
public class LocalTimeTest {
    @Test
    void nativeTime(){
       LocalDateTime parsed= LocalDateTime.parse("2020-01-23T12:23:56");
       Console.log(parsed.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
    @Test
    void localTime() {
        String dateStr = "2020-01-23T12:23:56";
        DateTime dt = DateUtil.parse(dateStr);

// Date对象转换为LocalDateTime
        LocalDateTime of = LocalDateTimeUtil.of(dt);
        Console.log(of);
// 时间戳转换为LocalDateTime
        of = LocalDateTimeUtil.ofUTC(dt.getTime());
        Console.log(of);
    }
    @Test
    void duration(){
        LocalDateTime start = LocalDateTimeUtil.parse("2019-02-02T00:00:00");
        LocalDateTime end = LocalDateTimeUtil.parse("2020-02-02T00:00:00");

        Duration between = LocalDateTimeUtil.between(start, end);

// 365
        Console.log(between.toDays());
    }

    @Test
    void timer(){
        TimeInterval timer = DateUtil.timer();

        for (int i = 0; i <10000; i++) {
            if (i%11==0) {
                Console.log(i);
            }

        }
//---------------------------------
//-------这是执行过程
//---------------------------------

        Console.log(timer.interval());//花费毫秒数
       Console.log("花费时间:{}", timer.intervalRestart());//返回花费时间，并重置开始时间
        Console.log("花费分钟数{}",timer.intervalMinute());//花费分钟数
    }

    @Test
    void timerGroup(){
        final TimeInterval timer = new TimeInterval();

// 分组1
        timer.start("1");
        ThreadUtil.sleep(800);

// 分组2
        timer.start("2");
        ThreadUtil.sleep(900);

        Console.log("Timer 1 took {} ms", timer.intervalMs("1"));
        Console.log("Timer 2 took {} ms", timer.intervalMs("2"));
    }
}
