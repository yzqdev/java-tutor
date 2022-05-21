package com.yzq.datatype;

import org.junit.jupiter.api.Test;

/**
 * @author yanni
 * @date time 2021/10/14 14:54
 * @modified By:
 */
 class CharTest {
    @Test
    void showCharTest() {
        String sentence = "盖伦,在进行了连续8次击杀后,获得了 超神 的称号";

        char c = sentence.charAt(0);

        System.out.println(c);
        //获取对应的字符数组
        char[] cs = sentence.toCharArray();
//截取从第3个开始的字符串 （基0）
        System.out.println(sentence.length() == cs.length);
        String subString1 = sentence.substring(3);

        System.out.println(subString1);

        //截取从第3个开始的字符串 （基0）
        //到5-1的位置的字符串
        //左闭右开
        String subString2 = sentence.substring(3, 5);

        System.out.println(subString2);
        //根据,进行分割，得到3个子字符串
        String[] subSentences = sentence.split(",");
        for (String sub : subSentences) {
            System.out.println(sub);
        }//全部变成小写
        System.out.println(sentence.toLowerCase());
        //全部变成大写
        System.out.println(sentence.toUpperCase());
//字符第一次出现的位置
        System.out.println(sentence.indexOf('8'));
//字符串第一次出现的位置
        System.out.println(sentence.indexOf("超神"));
        //字符串最后出现的位置
        System.out.println(sentence.lastIndexOf("了"));
//从位置5开始，出现的第一次,的位置
        System.out.println(sentence.indexOf(',', 5));
//是否包含字符串"击杀"
        System.out.println(sentence.contains("击杀"));
//替换所有的
        String temp = sentence.replaceAll("击杀", "被击杀");

        temp = temp.replaceAll("超神", "超鬼");

        System.out.println(temp);

        temp = sentence.replaceFirst(",", "");//只替换第一个

        System.out.println(temp);
    }

    @Test
    void primitive() {
        // byte
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
        System.out.println("包装类：java.lang.Byte");
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println();

        // short
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);
        System.out.println("包装类：java.lang.Short");
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);
        System.out.println();

        // int
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);
        System.out.println("包装类：java.lang.Integer");
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println();

        // long
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);
        System.out.println("包装类：java.lang.Long");
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println();

        // float
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println();

        // double
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
        System.out.println("包装类：java.lang.Double");
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println();

        // char
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：java.lang.Character");
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE="
                + (int) Character.MIN_VALUE);
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE="
                + (int) Character.MAX_VALUE);
    }
}
