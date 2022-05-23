package com.yzq.hutooltest;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdUtil;
import cn.hutool.log.LogFactory;
import cn.hutool.log.StaticLog;
import cn.hutool.log.dialect.console.ConsoleColorLogFactory;
import org.junit.jupiter.api.Test;

/**
 * @author yanni
 * @date time 2022/1/17 1:02
 * @modified By:
 */
class IdGen {
    @Test
    void genNanoId(){
        LogFactory.setCurrentLogFactory(ConsoleColorLogFactory.class);
        Console.log(IdUtil.randomUUID());
        Console.log(IdUtil.fastSimpleUUID());
        Console.log(IdUtil.nanoId());
        Console.log(IdUtil.simpleUUID());
        Console.log(IdUtil.fastUUID());
        Console.log("snowflakeId:"+IdUtil.getSnowflakeNextId());
    }
}
