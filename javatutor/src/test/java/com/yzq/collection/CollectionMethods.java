package com.yzq.collection;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
class Foo {

    String name;

    public Foo[] concat(Foo[] a, Foo[] b) {
        int aLen = a.length;
        int bLen = b.length;
        Foo[] c = new Foo[aLen + bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }
}

public class CollectionMethods {

    @Test
    public void stringFunction() {
        String s = "helloworld java is object";
        String a = "";
        String c = a.concat(s);
        System.out.println(c.charAt(4));
        System.out.println(c.hashCode());

        System.out.println(c);
    }

    @Test
    public void arrForeach() {
        List<Integer> numbers = Arrays.asList(-1, -2, 0, 4, 5);

        numbers.forEach((k) -> {
            System.out.println("这是数字:" + k);
        });
    }

    @Test
    public void vectorTest() {
        Vector<Object> v = new Vector<>(3, 2);
        System.out.println("Initial size: " + v.size());
        System.out.println("Initial capacity: " + v.capacity());
        v.addElement(1);
        v.addElement(2);
        v.addElement(3);
        v.addElement(4);
        System.out.println("Capacity after four additions: " +
                v.capacity());

        v.addElement(5.45);
        System.out.println("Current capacity: " +
                v.capacity());
        v.addElement(6.08);
        v.addElement(7);
        System.out.println("Current capacity: " +
                v.capacity());
        v.addElement((float) 9.4);
        v.addElement(10);
        System.out.println("Current capacity: " +
                v.capacity());
        v.addElement(11);
        v.addElement(12);
        System.out.println("First element: " +
                v.firstElement());
        System.out.println("Last element: " +
                v.lastElement());
        if (v.contains(3)) {
            System.out.println("Vector contains 3.");
        }
        // enumerate the elements in the vector.
        Enumeration<Object> vEnum = v.elements();
        System.out.println("\nElements in vector:");
        while (vEnum.hasMoreElements()) {
            System.out.print(vEnum.nextElement() + " ");
        }
    }

    @Test
    public void initArr() {

        //初始化对象数组
        Foo foobar = new Foo();
        Foo[] fooArr = foobar.concat(
                new Foo[]{new Foo("hhh"), new Foo("bbb")
                }, new Foo[]{new Foo("第二个")});
        System.out.println(Arrays.toString(fooArr));

        //第一种写法
        ArrayList<String> places = new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));

        //第二种写法

        ArrayList<String> arrayList = new ArrayList<>(6) {{
            add("first");
            add("second");
            add("third");
        }};

        HashMap<String, String> hashMap = new HashMap<>() {{
            put("first", "firstElement");
            put("second", "secondElement");
        }};
        System.out.println(Arrays.toString(fooArr));
        System.out.println(hashMap);
    }

    @Test
    public void sortYou() {
        ArrayList<String> sites = new ArrayList<>();
        sites.add("Taobao");
        sites.add("Wiki");
        sites.add("Runoob");
        sites.add("Weibo");
        sites.add("Google");
        Collections.sort(sites);  // 字母排序
        sites.forEach(s -> System.out.println(s + "地址"));

        for (String i : sites) {
            System.out.println(i);
        }
        sites.forEach(System.out::println);
    }


    @Test
    public void showHashable() {
        Hashtable<String, Double> balance = new Hashtable<>();
        Enumeration<String> names;
        String str;
        double bal;

        balance.put("Zara", 3434.34);
        balance.put("Mahnaz", 123.22);
        balance.put("Ayan", 1378.00);
        balance.put("Daisy", 99.22);
        balance.put("Qadir", -19.08);

        // Show all balances in hash table.
        names = balance.keys();
        Collection<Double> vs = balance.values();
        System.out.println(vs);
        while (names.hasMoreElements()) {
            str = names.nextElement();
            System.out.println(str + ": " + balance.get(str));
        }
        System.out.println();
        // Deposit 1,000 into Zara's account
        bal = balance.get("Zara");
        balance.put("Zara", bal + 1000);
        System.out.println("Zara's new balance: " + balance.get("Zara"));
    }
}

