package com.yzq.collection;

import org.junit.jupiter.api.Test;
import com.yzq.entity.charactor.Hero;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yanni
 * @date time 2021/10/14 12:01
 * @modified By:
 */
 class LinkListTest {
    @Test
     void deque() {
        LinkedList<Hero> ll = new LinkedList<>();
        ll.addLast(new Hero("hero1"));
        ll.addLast(new Hero("hero2"));
        ll.addLast(new Hero("hero3"));
        System.out.println(ll);
        //在最前面插入新的英雄
        ll.addFirst(new Hero("heroX"));
        System.out.println(ll);

        //查看最前面的英雄
        System.out.println(ll.getFirst());
        //查看最后面的英雄
        System.out.println(ll.getLast());

        //查看不会导致英雄被删除
        System.out.println(ll);
        //取出最前面的英雄
        System.out.println(ll.removeFirst());

        //取出最后面的英雄
        System.out.println(ll.removeLast());

        //取出会导致英雄被删除
        System.out.println(ll);
    }

    @Test
     void queue1() {


        //所不同的是LinkedList还实现了Deque，进而又实现了Queue这个接口
        //Queue代表FIFO 先进先出的队列
        Queue<Hero> q = new LinkedList<>();

        //加在队列的最后面
        System.out.print("初始化队列：\t");
        q.offer(new Hero("Hero1"));
        q.offer(new Hero("Hero2"));
        q.offer(new Hero("Hero3"));
        q.offer(new Hero("Hero4"));

        System.out.println(q);
        System.out.print("把第一个元素取poll()出来:\t");
        //取出第一个Hero，FIFO 先进先出
        Hero h = q.poll();
        System.out.println(h);
        System.out.print("取出第一个元素之后的队列:\t");
        System.out.println(q);

        //把第一个拿出来看一看，但是不取出来
        h = q.peek();
        System.out.print("查看peek()第一个元素:\t");
        System.out.println(h);
        System.out.print("查看并不会导致第一个元素被取出来:\t");
        System.out.println(q);
    }

    void insertFirst(List<Integer> l, String type) {
        int total = 1000 * 100;
        final int number = 5;
        long start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            l.add(0, number);
        }
        long end = System.currentTimeMillis();
        System.out.printf("在%s 最前面插入%d条数据，总共耗时 %d 毫秒 %n", type, total, end - start);


    }

    @Test
    void modify(List<Integer> l, String type) {
        int total = 100 * 1000;
        int index = total / 2;
        final int number = 5;
        //初始化
        for (int i = 0; i < total; i++) {
            l.add(number);
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < total; i++) {
            int n = l.get(index);
            n++;
            l.set(index, n);
        }
        long end = System.currentTimeMillis();
        System.out.printf("%s总长度是%d，定位到第%d个数据，取出来，加1，再放回去%n 重复%d遍，总共耗时 %d 毫秒 %n", type, total, index, total, end - start);
        System.out.println();
    }
}
