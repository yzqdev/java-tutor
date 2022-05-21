package com.yzq.collection;


import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author: Yangzhengqian
 * @Description:
 * @Date:Created time 2019/6/29 13:06
 * @Modified By:
 */
 class OtherCollectionTest {

    @Test
     void test1() {
        Properties capitals = new Properties();
        Set<Object> states;
        String str;

        capitals.put("Illinois", "Springfield");
        capitals.put("Missouri", "Jefferson City");
        capitals.put("Washington", "Olympia");
        capitals.put("California", "Sacramento");
        capitals.put("Indiana", "Indianapolis");

        // Show all states and capitals in hashtable.
        states = capitals.keySet(); // get set-view of keys
        System.out.println(capitals);
        for (Object state : states) {
            str = (String) state;
            System.out.println("The capital of " + str + " is " + capitals.getProperty(str) + ".");
        }
        System.out.println();

        // look for state not in list -- specify default
        str = capitals.getProperty("Florida", "Not Found");
        System.out.println("The capital of Florida is " + str + ".");
    }

    @Test
     void test2() {

        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
        System.out.println(myList);
    }

    @Test
     void charts() {
        String str = "这是一个字符串";
        str.chars().mapToObj(String::valueOf).forEach(System.out::println);
        str.chars().forEach(System.out::println);
        System.out.println("____________________");
        System.out.println("foo");
    }

    @Test
     void single() {
        List<String> list = new ArrayList<>(List.of("aaa", "bbb", "c", "d", "e", "f", "t", "z"));
        Collections.reverse(list);

        System.out.println(list);
        Collections.shuffle(list);
        list.sort((o1, o2) -> {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            return s1.compareTo(s2);
        });
        List<String> list1 = Arrays.asList("aaa", "bbb");
        System.out.println(list);
    }
}
