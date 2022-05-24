package com.yzq.hutooltest;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import org.junit.jupiter.api.Test;

/**
 * @author yanni
 * @date time 2022/5/24 8:08
 * @modified By:
 */
public class FileUtilTest {
    @Test
    void ls(){
        Console.log(FileUtil.ls("c:\\windows"));
    }
}
