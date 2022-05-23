package com.yzq.hutooltest;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.lang.Singleton;
import cn.hutool.core.lang.Validator;
import org.junit.jupiter.api.Test;

/**
 * @author yanni
 * @date time 2022/5/24 6:59
 * @modified By:
 */
public class DicTest {
    @Test
    void dicTest() {
        Dict dict = Dict.create()
                .set("key1", 1)//int
                .set("key2", 1000L)//long
                .set("key3", DateTime.now());//Date
        Console.log(dict);
        Long value = dict.getLong("key2");
        Console.log(value);

    }


    /**
     * 动物接口
     *
     * @author loolly
     */
    public static interface Animal {
        public void say();
    }

    /**
     * 狗实现
     *
     * @author loolly
     */
    public static class Dog implements Animal {
        @Override
        public void say() {
            System.out.println("汪汪");
        }
    }

    /**
     * 猫实现
     *
     * @author loolly
     */
    public static class Cat implements Animal {
        @Override
        public void say() {
            System.out.println("喵喵");
        }
    }

    @Test
    void singletonTest() {
        Animal dog = Singleton.get(Dog.class);
        Animal cat = Singleton.get(Cat.class);

        //单例对象每次取出为同一个对象，除非调用Singleton.destroy()或者remove方法
        System.out.println(dog == Singleton.get(Dog.class));        //True
        System.out.println(cat == Singleton.get(Cat.class));            //True

        dog.say();        //汪汪
        cat.say();        //喵喵
    }

    @Test
    void validateStr(){
        Console.log(Validator.isEmail("loolly@gmail.com"));
        Console.log(Validator.isMobile("13800138000"));
        Console.log(Validator.isIpv4("4.01.02.1"));
    }
}
