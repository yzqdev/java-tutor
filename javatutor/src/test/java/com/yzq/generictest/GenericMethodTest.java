package com.yzq.generictest;

import org.junit.jupiter.api.Test;

/**
 * 通用测试方法
 *E - Element (在集合中使用，因为集合中存放的是元素)<br>
 * T - Type（Java 类）<br>
 * K - Key（键）<br>
 * V - Value（值）<br>
 * N - Number（数值类型）<br>
 * ？ - 表示不确定的 java 类型<br>
 * @author yanni
 * @date 2021/11/30
 */
public class GenericMethodTest {
    // 泛型方法 printArray
    public static <E> void printArray(E[] inputArray) {
        // 输出数组元素
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    @Test
    void arrayGeneric() {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

        System.out.println("整型数组元素为:");
        printArray(intArray); // 传递一个整型数组

        System.out.println("\n双精度型数组元素为:");
        printArray(doubleArray); // 传递一个双精度型数组

        System.out.println("\n字符型数组元素为:");
        printArray(charArray); // 传递一个字符型数组
    }
}