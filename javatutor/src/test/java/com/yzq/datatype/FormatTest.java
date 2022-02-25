package com.yzq.datatype;

import org.junit.jupiter.api.Test;

import java.util.Locale;

/**
 * @author yanni
 * @date time 2021/10/14 14:56
 * @modified By:
 */
public class FormatTest {
    @Test
    void formatNumber() {
        String name = "盖伦";
        int kill = 8;
        String title = "超神";

        //直接使用+进行字符串连接，编码感觉会比较繁琐，并且维护性差,易读性差
        String sentence = name + " 在进行了连续 " + kill + " 次击杀后，获得了 " + title + " 的称号";

        System.out.println(sentence);

        //使用格式化输出
        //%s表示字符串，%d表示数字,%n表示换行
        String sentenceFormat = "%s 在进行了连续 %d 次击杀后，获得了 %s 的称号%n";
        System.out.printf(sentenceFormat, name, kill, title);
    }

    @Test
    void format2() {
        String name = "盖伦";
        int kill = 8;
        String title = "超神";

        String sentenceFormat = "%s 在进行了连续 %d 次击杀后，获得了 %s 的称号%n";
        //使用printf格式化输出
        System.out.printf(sentenceFormat, name, kill, title);
        //使用format格式化输出
        System.out.format(sentenceFormat, name, kill, title);
    }

    @Test
    void format3() {
        int year = 2020;
        //总长度，左对齐，补0，千位分隔符，小数点位数，本地化表达

        //直接打印数字
        System.out.format("%d%n", year);
        //总长度是8,默认右对齐
        System.out.format("%8d%n", year);
        //总长度是8,左对齐
        System.out.format("%-8d%n", year);
        //总长度是8,不够补0
        System.out.format("%08d%n", year);
        //千位分隔符
        System.out.format("%,8d%n", year * 10000);

        //小数点位数
        System.out.format("%.2f%n", Math.PI);

        //不同国家的千位分隔符
        System.out.format(Locale.FRANCE, "%,.2f%n", Math.PI * 10000);
        System.out.format(Locale.US, "%,.2f%n", Math.PI * 10000);
        System.out.format(Locale.UK, "%,.2f%n", Math.PI * 10000);
    }

    @Test
    void formatChar() {
        System.out.println(Character.isLetter('a'));//判断是否为字母
        System.out.println(Character.isDigit('a')); //判断是否为数字
        System.out.println(Character.isWhitespace(' ')); //是否是空白
        System.out.println(Character.isUpperCase('a')); //是否是大写
        System.out.println(Character.isLowerCase('a')); //是否是小写

        System.out.println(Character.toUpperCase('a')); //转换为大写
        System.out.println(Character.toLowerCase('A')); //转换为小写

        //String a = 'a'; //不能够直接把一个字符转换成字符串
        String a2 = Character.toString('a'); //转换为字符串
    }

    @Test
    void formatChar2() {
        System.out.println("使用空格无法达到对齐的效果");
        System.out.println("abc def");
        System.out.println("ab def");
        System.out.println("a def");

        System.out.println("使用\\t制表符可以达到对齐的效果");
        System.out.println("abc\tdef");
        System.out.println("ab\tdef");
        System.out.println("a\tdef");

        System.out.println("一个\\t制表符长度是8");
        System.out.println("12345678def");

        System.out.println("换行符 \\n");
        System.out.println("abc\ndef");

        System.out.println("单引号 \\'");
        System.out.println("abc\'def");
        System.out.println("双引号 \\\"");
        System.out.println("abc\"def");
        System.out.println("反斜杠本身 \\");
        System.out.println("abc\\def");
    }
}
