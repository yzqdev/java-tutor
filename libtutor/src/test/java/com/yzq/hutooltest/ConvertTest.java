package com.yzq.hutooltest;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.CharsetUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;


/**
 * @author yanni
 * @date time 2022/5/24 6:27
 * @modified By:
 */
public class ConvertTest {
    @Test
    void primitive(){
        int a = 1;
//aStr为"1"
        String aStr = Convert.toStr(a);
Console.log(aStr);
        long[] b = {1,2,3,4,5};
//bStr为："[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(b);
        Console.log(bStr);
    }
    @Test
    void primitiveArray(){
        String[] b = { "1", "2", "3", "4" };
//结果为Integer数组
        Integer[] intArray = Convert.toIntArray(b);
Console.log(intArray);
        long[] c = {1,2,3,4,5};
//结果为Integer数组
        Integer[] intArray2 = Convert.toIntArray(c);
        Console.log(intArray2);

        String a = "2017-05-06";
        Date value = Convert.toDate(a);
        Object[] obj = {"a", "你", "好", "", 1};
        List<?> list = Convert.convert(List.class, obj);
//从4.1.11开始可以这么用
        List<?> list2 = Convert.toList(a);
    }
    @Test
    void unicode(){
        String a = "我是一个小小的可爱的字符串";

//结果为："\\u6211\\u662f\\u4e00\\u4e2a\\u5c0f\\u5c0f\\u7684\\u53ef\\u7231\\u7684\\u5b57\\u7b26\\u4e32"
        String unicode = Convert.strToUnicode(a);
Console.log(unicode);
//结果为："我是一个小小的可爱的字符串"
        String raw = Convert.unicodeToStr(unicode);
        Console.log(raw);
    }
    @Test
    void charset(){
        String a = "我不是乱码";
//转换后result为乱码
        String result = Convert.convertCharset(a, CharsetUtil.UTF_8, CharsetUtil.ISO_8859_1);
        String raw = Convert.convertCharset(result, CharsetUtil.ISO_8859_1, "UTF-8");
        Assertions.assertEquals(raw, a);
    }
    @Test
    void others(){
        double a = 67556.32;

//结果为："陆万柒仟伍佰伍拾陆元叁角贰分"
        String digitUppercase = Convert.digitToChinese(a);
Console.log(digitUppercase);
        // ONE HUNDRED AND CENTS TWENTY THREE ONLY
        Console.log(Convert.numberToWord(100.23));

        // 1.2k
       Console.log(Convert.numberToSimple(12000000 ));


        // 一万零八百八十九点七二
        Console.log(Convert.numberToChinese(10889.72356, false));

// 使用金额大写
// 壹万贰仟陆佰伍拾叁
      Console.log(Convert.numberToChinese(12653, true));


        // 1012
       Console.log(Convert.chineseToNumber("一千零一十二"));
    }
}
