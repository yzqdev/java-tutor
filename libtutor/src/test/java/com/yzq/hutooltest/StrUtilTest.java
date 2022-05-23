package com.yzq.hutooltest;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.EscapeUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;

/**
 * @author yanni
 * @date time 2022/5/24 6:49
 * @modified By:
 */
public class StrUtilTest {
    @Test
    void escapeTest(){
        String url="https://www.baidu.com/s?wd=双海大学";
        System.out.println(EscapeUtil.escape(url));
    }

    @Test
    void strFormatTest(){
        String template = "{}爱{}，就像老鼠爱大米";
        String str = StrUtil.format(template, "我", "你"); //str -> 我爱你，就像老鼠爱大米
        Console.log(str);
    }
}
