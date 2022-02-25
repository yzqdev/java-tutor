package com.yzq.hutooltest;

import cn.hutool.captcha.*;
import cn.hutool.captcha.generator.MathGenerator;

import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.lang.Console;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

/**
 * @author yanni
 * @date time 2022/1/16 21:52
 * @modified By:
 */
public class CaptchaTest {

    @Test
    public void lineCaptchaTest1() {
        // 定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        lineCaptcha.write("d:/tmp/a.jpg");
        Assertions.assertNotNull(lineCaptcha.getCode());
        System.out.println(lineCaptcha.getCode());
        Assertions.assertTrue(lineCaptcha.verify(lineCaptcha.getCode()));
    }

    @Test

    public void lineCaptchaTest3() {
        // 定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 70, 4, 15);
        lineCaptcha.setBackground(Color.yellow);
        lineCaptcha.write("d:/tmp/tellow.png");
    }

    @Test

    public void lineCaptchaWithMathTest() {
        // 定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 80);
        lineCaptcha.setGenerator(new MathGenerator());
        lineCaptcha.setTextAlpha(0.8f);
        lineCaptcha.createCode();
        lineCaptcha.write("d:/tmp/math.png");
        System.out.println(lineCaptcha.getCode());
    }

    @Test
    public void lineCaptchaTest2() {

        // 定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        // LineCaptcha lineCaptcha = new LineCaptcha(200, 100, 4, 150);
        // 图形验证码写出，可以写出到文件，也可以写出到流
        lineCaptcha.write("D:/tmp/line.png");
        Console.log(lineCaptcha.getCode());
        // 验证图形验证码的有效性，返回boolean值
        lineCaptcha.verify("1234");

        lineCaptcha.createCode();
        lineCaptcha.write("D:/tmp/line2.png");
        Console.log(lineCaptcha.getCode());
        // 验证图形验证码的有效性，返回boolean值
        lineCaptcha.verify("1234");
    }

    @Test
    public void circleCaptchaTest() {

        // 定义图形验证码的长和宽
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
        // CircleCaptcha captcha = new CircleCaptcha(200, 100, 4, 20);
        // 图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write("D:/tmp/circle.png");
        // 验证图形验证码的有效性，返回boolean值
        captcha.verify("1234");
    }

    @Test
    public void shearCaptchaTest() {

        // 定义图形验证码的长和宽
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(203, 100, 4, 4);
        // ShearCaptcha captcha = new ShearCaptcha(200, 100, 4, 4);
        // 图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write("d:/tmp/shear.png");
        // 验证图形验证码的有效性，返回boolean值
        captcha.verify("1234");
    }

    @Test
    public void shearCaptchaTest2() {

        // 定义图形验证码的长和宽
        ShearCaptcha captcha = new ShearCaptcha(200, 100, 4, 4);
        // 图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write("d:/tmp/shear.png");
        // 验证图形验证码的有效性，返回boolean值
        captcha.verify("1234");
    }

    @Test
    public void ShearCaptchaWithMathTest() {
        // 定义图形验证码的长和宽
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 45, 4, 4);
        captcha.setGenerator(new MathGenerator());
        // ShearCaptcha captcha = new ShearCaptcha(200, 100, 4, 4);
        // 图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write("d:/tmp/shear_math.png");
        // 验证图形验证码的有效性，返回boolean值
        captcha.verify("1234");
    }

    @Test
    public void GifCaptchaTest() {
        GifCaptcha captcha = CaptchaUtil.createGifCaptcha(200, 100, 4);
        captcha.write("d:/tmp/gif_captcha.gif");
        captcha.verify(captcha.getCode());
    }

    @Test
    public void bgTest() {
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(200, 100, 4, 1);
        captcha.setBackground(Color.WHITE);
        captcha.write("d:/tmp/test.jpg");
    }

    @Test
    public void NumberGen() {
        // 自定义纯数字的验证码（随机4位数字，可重复）
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 4);
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        lineCaptcha.setGenerator(randomGenerator);
// 重新生成code
        lineCaptcha.createCode();
        lineCaptcha.write("d:/tmp/shear.jpg");

    }

    @Test
    public void captcharNum() {
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 45, 4, 4);
// 自定义验证码内容为四则运算方式
        captcha.setGenerator(new MathGenerator());
// 重新生成code
        captcha.createCode();
        captcha.write("d:/tmp/shear.jpg");
        System.out.println(captcha.getCode());
    }
}
