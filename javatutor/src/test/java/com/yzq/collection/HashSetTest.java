package com.yzq.collection;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author yanni
 * @date time 2021/10/14 12:04
 * @modified By:
 */
public class HashSetTest {
    void init() {
        HashSet<String> names = new HashSet<>();
        names.add("anderson");
        names.add("camel");
        System.out.println(names);
    }

    @Test
    void showCircles() {
        HashSet<String> strs = new HashSet<>();
        strs.add("first");
        strs.add("second");
        strs.add("third");
        for (int i = 0; i < 10; i++) {
            strs.add("boy" + i);
        }
        //使用迭代器：
        for (Iterator<String> iterator = strs.iterator(); iterator.hasNext(); ) {
            String newstring = iterator.next();
            System.out.println(newstring);
        }
        //高级for循环
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
