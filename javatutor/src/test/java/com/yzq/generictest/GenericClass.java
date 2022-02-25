package com.yzq.generictest;

import org.junit.jupiter.api.Test;

/**
 * 泛型类
 *E - Element (在集合中使用，因为集合中存放的是元素)<br>
 * T - Type（Java 类）<br>
 * K - Key（键）<br>
 * V - Value（值）<br>
 * N - Number（数值类型）<br>
 * ？ - 表示不确定的 java 类型<br>
 * @author yanni
 * @date 2021/11/30
 */
public class GenericClass<T> {

    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    @Test
    void mainMethod() {
        GenericClass<Integer> integerGenericClass = new GenericClass<>();
        GenericClass<String> stringGenericClass = new GenericClass<>();

        integerGenericClass.add(10);
        stringGenericClass.add("菜鸟教程");

        System.out.printf("整型值为 :%d\n\n", integerGenericClass.get());
        System.out.printf("字符串为 :%s\n", stringGenericClass.get());
    }
}