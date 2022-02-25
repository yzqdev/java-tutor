package com.yzq.collection;

import org.junit.jupiter.api.Test;
import com.yzq.entity.charactor.Hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yanni
 * @date time 2021/10/14 11:59
 * @modified By:
 */
public class ArrayListTest {

    /**
     * Arraytest.
     */
    @Test
    void arrayTest() {

        ArrayList<Hero> heros = new ArrayList<>();

        heros.add(new Hero("garen"));
        System.out.println(heros.size());
        heros.add(new Hero("timeo"));
        System.out.println(heros.size());
    }

    /**
     * Addfun.
     */
    @Test
    void addFun() {
        ArrayList<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heroes.add(new Hero("hero" + i));
        }
        System.out.println(heroes);
        Hero specialhero = new Hero("special hero");
        heroes.add(3, specialhero);
        System.out.println(heroes);
        System.out.println(heroes.contains("包含" + specialhero));
        System.out.println(heroes.get(4));
        System.out.println(heroes.indexOf(specialhero));
        System.out.println(heroes.indexOf(new Hero("hero 34")));
        heroes.remove(specialhero);
        System.out.println("删除后的" + heroes);
        heroes.set(1, new Hero("hero new2"));
        System.out.println(heroes);
        System.out.println(heroes.size());
        //转为数组
        Hero[] hs = heroes.toArray(new Hero[]{});
        System.out.println("数组" + Arrays.toString(hs));
        heroes.clear();
        System.out.println(heroes);
    }

    /**
     * Addanotherhero.
     */
    @Test
    void addAnotherHero() {
        ArrayList<Hero> anoterheros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            anoterheros.add(new Hero("anotherhero" + i));
        }
        ArrayList<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heroes.add(new Hero("hero" + i));
        }
        heroes.addAll(anoterheros);
        System.out.println(heroes);
    }

    /**
     *
     */
    @Test
    void iteratorTest() {
        List<Hero> heros = new ArrayList<>();

        //放5个Hero进入容器
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero name " + i));
        }

        //第二种遍历，使用迭代器
        System.out.println("--------使用while的iterator-------");
        //从最开始的位置判断"下一个"位置是否有数据
        //如果有就通过next取出来，并且把指针向下移动
        //直到"下一个"位置没有数据
        for (Hero h : heros) {
            System.out.println(h);
        }
        //迭代器的for写法
        System.out.println("--------使用for的iterator-------");
        for (Hero hero : heros) {
            System.out.println(hero);
        }
    }

    @Test
    void enhancedFor() {
        List<Hero> heros = new ArrayList<Hero>();

        // 放5个Hero进入容器
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero name " + i));
        }

        // 第三种，增强型for循环
        System.out.println("--------增强型for循环-------");
        for (Hero h : heros) {
            System.out.println(h);
        }
    }

    @Test
    void shuffle() {
        //初始化集合numbers
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        System.out.println("集合中的数据:");
        System.out.println(numbers);
        Collections.reverse(numbers);

        System.out.println("翻转后集合中的数据:");
        System.out.println(numbers);
        Collections.shuffle(numbers);

        System.out.println("混淆后集合中的数据:");
        System.out.println(numbers);
        Collections.sort(numbers);
        System.out.println("排序后集合中的数据:");
        System.out.println(numbers);

        Collections.swap(numbers, 0, 5);
        System.out.println("交换0和5下标的数据后，集合中的数据:");
        System.out.println(numbers);
        Collections.rotate(numbers, 2);
        System.out.println("把集合向右滚动2个单位，标的数据后，集合中的数据:");
        System.out.println(numbers);
        System.out.println("把非线程安全的List转换为线程安全的List");
        List<Integer> synchronizedNumbers = Collections.synchronizedList(numbers);
    }

    @Test
    void arrays() {

        //1、对象类型(String型)的数组数组使用asList()，正常
        String[] strings = {"aa", "bb", "cc"};
        List<String> stringList = Arrays.asList(strings);
        System.out.print("1、String类型数组使用asList()，正常：  ");
        for (String str : stringList) {
            System.out.print(str + " ");
        }
        System.out.println();


        //2、对象类型(Integer)的数组使用asList()，正常
        Integer[] integers = new Integer[]{1, 2, 3};
        List<Integer> integerList = Arrays.asList(integers);
        System.out.print("2、对象类型的数组使用asList()，正常：  ");
        for (int i : integerList) {
            System.out.print(i + " ");
        }
//        for(Object o : integerList){
//            System.out.print(o + " ");
//        }
        System.out.println();


        //3、基本数据类型的数组使用asList()，出错
        Integer[] ints =  {1, 2, 3};
        List<Integer> intList = Arrays.asList(ints);
        System.out.print("3、基本数据类型的数组使用asList()，出错(输出的是一个引用，把ints当成一个元素了)：");
        for (Object o : intList) {
            System.out.print(o.toString());
        }
        System.out.println();

        System.out.print("   " + "这样遍历才能正确输出：");
       //Integer[] ints1 =   intList.get(0);
       // for (int i : ints1) {
       //     System.out.print(i + " ");
       // }
        System.out.println();

        //4、当更新数组或者List,另一个将自动获得更新
        System.out.print("4、当更新数组或者List,另一个将自动获得更新：  ");
        integerList.set(0, 5);
        for (Object o : integerList) {
            System.out.print(o + " ");
        }
        for (Object o : integers) {
            System.out.print(o + " ");
        }
        System.out.println();

        //5、add()   remove() 报错
        System.out.print("5、add()   remove() 报错：  ");
//        integerList.remove(0);
//        integerList.add(3, 4);
//        integerList.clear();
    }


}
