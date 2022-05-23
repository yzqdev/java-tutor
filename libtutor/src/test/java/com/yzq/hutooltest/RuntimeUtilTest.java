package com.yzq.hutooltest;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.RuntimeUtil;
import org.junit.jupiter.api.Test;

/**
 * @author yanni
 * @date time 2022/5/24 6:18
 * @modified By:
 */
  class RuntimeUtilTest {
    @Test
    void getRuntime() {

      String s= RuntimeUtil.execForStr("ipconfig");
      Console.log(s);
    }

}
