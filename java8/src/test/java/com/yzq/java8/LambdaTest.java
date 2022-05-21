package com.yzq.java8;

import com.yzq.entity.charactor.Hero;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author yzq
 * @date  time 2021/10/12 20:42
 */
 class LambdaTest {
    @Test
    void lambda1() {
       LambdaTest tester=new LambdaTest();

        // 类型声明
        MathOperation addition = Integer::sum;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> a * b;

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + this.operate(10, 5, addition));
        System.out.println("10 - 5 = " + this.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + this.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + this.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
    @Test
    void lambyda1() {
        Random r = new Random();
        List<Hero> heros = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("筛选出 hp>100 && damange<50的英雄");
        filter(heros);
    }

    private static void filter(List<Hero> heros) {
        for (Hero hero : heros) {
            if (hero.hp > 100 && hero.damage < 50) {
                System.out.print(hero);
            }
        }
    }

    @Test
     void shortenMap() {
        Map<String, String> map = new HashMap<>(5);
        map.put("a", "a1");
        map.put("b", "b1");
        map.put("c", "c1");
        map.put("d", "d1");
        System.out.println(map.keySet());
        System.out.println("map普通方式遍历:");
        map.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });
        for (String key : map.keySet()) {
            System.out.println("k=" + key + "，v=" + map.get(key));
        }
    }

    @Test
     void showMap() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("bb");
        list.add("ccc");
        list.add("dddd");
        System.out.println("list拉姆达表达式遍历:");
        list.forEach((k) -> {
            System.out.println(k);
        });
        System.out.println("list双冒号运算符遍历:");
        list.forEach(System.out::println);
    }
}
