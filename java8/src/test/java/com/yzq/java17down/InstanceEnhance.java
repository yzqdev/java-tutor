package com.yzq.java17down;

import org.junit.jupiter.api.Test;

/**
 * @author yanni
 * @date time 2021/10/12 22:02
 * @modified By:
 */
public class InstanceEnhance {
    /**
     * 新版本的instanceof的使用，无须显示强转
     */
    @Test
    public void testOld() {
        Object strObj = "Hello Instanceof!";
        if (strObj instanceof String  ) {
            String str=(String) strObj;
            // 无需显示的进行强转
            System.out.println(str.contains("Hello"));
        }
    } @Test
    public void testNew() {
        Object strObj = "Hello Instanceof!";
        if (strObj instanceof String str) {
            // 无需显示的进行强转
            System.out.println(str.contains("Hello"));
        }
    }
}
