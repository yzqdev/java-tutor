package com.yzq.java8;

import com.yzq.entity.charactor.Hero;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author yzq
 * @date  time 2021/10/12 20:42
 */
public class LambdaTest {
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
    public void shortenMap() {
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
    public void showMap() {
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
