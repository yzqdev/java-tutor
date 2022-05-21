package com.yzq.datetutor;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author yanni
 * @date time 2021/10/14 11:48
 * @modified By:
 */
  class DateTest {
    @Deprecated
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    void testCalendar() {
        Calendar c = Calendar.getInstance();
        Date d = c.getTime();
        Date d2 = new Date(0);
        Date now = c.getTime();
        c.setTime(d2);
        System.out.println(format(c.getTime()));
        c.setTime(now);
        c.add(Calendar.MONTH, 1);
        System.out.println(format(c.getTime()));
    }

    private static String format(Date time) {
        return sdf.format(time);
    }

    @Test
    void testDate1() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String str = "2016/1/4 12:12:12";
        try {
            Date d = sdf.parse(str);
            System.out.printf("%s %n traslated into %s", str, d.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testDate2() {
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        // 当前日期
        System.out.println("当前日期：\t" + format(calendar.getTime()));

        // 下个月的今天
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, 1);
        System.out.println("下个月的今天:\t" + format(calendar.getTime()));

        // 去年的今天
        calendar.setTime(now);
        calendar.add(Calendar.YEAR, -1);
        System.out.println("去年的今天:\t" + format(calendar.getTime()));

        // 上个月的第三天
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DATE, 3);
        System.out.println("上个月的第三天:\t" + format(calendar.getTime()));

    }
    @Test
     void timeZone(){
        TimeZone tzDefault = TimeZone.getDefault(); // 当前时区
        TimeZone tzGMT9 = TimeZone.getTimeZone("GMT+09:00"); // GMT+9:00时区
        TimeZone tzNY = TimeZone.getTimeZone("America/New_York"); // 纽约时区
        System.out.println(tzDefault.getID()); // Asia/Shanghai
        System.out.println(tzGMT9.getID()); // GMT+09:00
        System.out.println(tzNY.getID()); // America/New_York
    }
}
