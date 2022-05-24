package com.yzq.hutooltest;

import cn.hutool.core.lang.Console;
import cn.hutool.system.SystemUtil;
import org.junit.jupiter.api.Test;

/**
 * @author yanni
 * @date time 2022/5/24 8:31
 * @modified By:
 */
public class SystemUtilTest {
    @Test
    void systemTest(){
        Console.log(SystemUtil.getJavaRuntimeInfo());
        Console.log(SystemUtil.getUserInfo());
        Console.log(SystemUtil.getJavaInfo());
        Console.log(SystemUtil.getOsInfo());
    }
}
