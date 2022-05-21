package com.yzq.java17down;

import cn.hutool.core.lang.Console;
import org.junit.jupiter.api.Test;

/**
 * @author yanni
 * @date time 2021/10/12 22:05
 * @modified By:
 * @since jdk15
 */
 class TextBlockTest {
    @Test
     void showTextBlock(){
        String query = """
               SELECT "EMP_ID", "LAST_NAME" FROM "EMPLOYEE_TB"
               WHERE "CITY" = 'INDIANAPOLIS'
               ORDER BY "EMP_ID", "LAST_NAME";
               """;
        Console.log("QUERY={}",query);
    }
}
