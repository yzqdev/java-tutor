package com.yzq.datatype;

import org.junit.jupiter.api.Test;

/**
 * @author yanni
 * @date time 2021/10/14 14:57
 * @modified By:
 */
 class MathTypeTest {
    @Test
    void digitMath() {
        float f1 = 5.4f;
        float f2 = 5.5f;
        //5.4四舍五入即5
        System.out.println(Math.round(f1));
        //5.5四舍五入即6
        System.out.println(Math.round(f2));

        //得到一个0-1之间的随机浮点数（取不到1）
        System.out.println(Math.random());

        //得到一个0-10之间的随机整数 （取不到10）
        System.out.println((int) (Math.random() * 10));
        //开方
        System.out.println(Math.sqrt(9));
        //次方（2的4次方）
        System.out.println(Math.pow(2, 4));

        //π
        System.out.println(Math.PI);

        //自然常数
        System.out.println(Math.E);
    }

     static void getLne() {
        double e = 1.0;
        double t = 1.0;
        for (int i = 1; i <= 20; i++) {
            t /= i;
            e += t;
        }
        System.out.println(e==Math.round(Math.E));
    }

}
