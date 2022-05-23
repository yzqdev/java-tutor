package com.yzq.hutooltest;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Console;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.StaticLog;
import cn.hutool.log.dialect.console.ConsoleLogFactory;
import cn.hutool.log.level.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yanni
 * @date time 2022/5/24 6:19
 * @modified By:
 */
 class ConsoleTest {


     ConsoleTest(){
         //自定义日志实现为Console Logging
         LogFactory.setCurrentLogFactory(new ConsoleLogFactory());
     }
     @Test
     void console(){
         Console.log("This is {} log.", Level.DEBUG);
         Console.print("This is {} log.", Level.INFO);
         Console.error("This is {} log.", Level.ERROR);
         Console.print("This is {} log.", Level.WARN);
         Console.lineNumber();
     }
    @Test
    void logFactory(){
        Log log = LogFactory.get();

        log.debug("This is {} log", Level.DEBUG);
        log.info("This is {} log", Level.INFO);
        log.warn("This is {} log", Level.WARN);

        Exception e = new Exception("test Exception");
        log.error(e, "This is {} log", Level.ERROR);
    }

    @Test
    void staticLog(){
        StaticLog.info("This is static {} log.", "INFO");
        StaticLog.debug("This is static {} log.", "INFO");
        StaticLog.error("This is static {} log.", "INFO");
        StaticLog.warn("This is static {} log.", "INFO");
        Assertions.assertEquals(1, (int) Convert.toInt(true));
    }
}
