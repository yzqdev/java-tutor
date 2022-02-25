package com.yzq.tutor.utils;

import java.util.Arrays;

/**
 * Created time 2021/3/2 12:38
 *
 * @author Yangzhengqian
 */
public class OperateUtil {
    public static void main(String[] args) {
        String[][] b = new String[3][4];
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                b[i][j] = "A" + j;
            }
        }
        System.out.println(Arrays.toString(b));
        //输出[[Ljava.lang.String;@55e6cb2a, [Ljava.lang.String;@23245e75, [Ljava.lang.String;@28b56559]
        System.out.println(Arrays.deepToString(b));
    }
}
