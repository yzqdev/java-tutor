package com.yzq.exceptionT;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yanni
 * @date time 2022/1/6 13:46
 * @modified By:
 */
public class Ex {
    @Test
    public void testException() {

        File f = new File("d:/MiFlashvcom.ini");

        try {
            System.out.println("试图打开 d:/MiFlashvcom.ini");
            new FileInputStream(f);
            System.out.println("成功打开");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse("2016/06/03");
        } catch (FileNotFoundException | ParseException e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("d:/LOL.exe不存在");
            }
            if (e instanceof ParseException) {
                System.out.println("日期格式解析错误");
            }

            e.printStackTrace();
        }

    }
}
