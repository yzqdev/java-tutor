package com.yzq.collection;

import org.junit.jupiter.api.Test;
import com.yzq.entity.charactor.Hero;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author yanni
 * @date time 2021/10/14 12:05
 * @modified By:
 */
 class HashMapTest {
    @Test
    void init(){
        HashMap<String ,String> dic=new HashMap<>();
        dic.put("adc", "sheshou");
        dic.put("apc", "fashi");
        System.out.println(dic);
        for (Map.Entry<String, String> entry : dic.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        System.out.println(dic.get("apc"));
    }
    @Test
    void changValue(){
        HashMap<String, Hero> heroMap = new HashMap<>();

        heroMap.put("gareen", new Hero("gareen1"));
        System.out.println(heroMap);

        //key为gareen已经有value了，再以gareen作为key放入数据，会导致原英雄，被覆盖
        //不会增加新的元素到Map中
        heroMap.put("gareen", new Hero("gareen2"));
        System.out.println(heroMap);

        //清空map
        heroMap.clear();
        Hero gareen = new Hero("gareen");

        //同一个对象可以作为值插入到map中，只要对应的key不一样
        heroMap.put("hero1", gareen);
        heroMap.put("hero2", gareen);

        System.out.println(heroMap);
    }
    void hashmap(){
        HashMap<String,String> hashMap = new HashMap<>();

        //HashMap可以用null作key,作value
        hashMap.put(null, "123");
        hashMap.put("123", null);

        Hashtable<String,String> hashtable = new Hashtable<String,String>();
        //Hashtable不能用null作key，不能用null作value
        hashtable.put(null, "123");
        hashtable.put("123", null);

    }
}
