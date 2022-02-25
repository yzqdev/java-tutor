package com.yzq.thisfunc;

import org.junit.jupiter.api.Test;

class Person {
    public static void prt(String s) {
        System.out.println(s);
    }

    Person() {
        prt("父类·无参数构造方法： " + "A Person.");
    }//构造方法(1) 

    Person(String name) {
        prt("父类·含一个参数的构造方法： " + "A person's name is " + name);
    }//构造方法(2) 
}

/**
 * @author yanni
 */
public class Chinese extends Person {
    Chinese() {
        // 调用父类构造方法（1）
        super();
        prt("子类·调用父类”无参数构造方法“： " + "A chinese coder.");
    }

    Chinese(String name) {
        // 调用父类具有相同形参的构造方法（2）
        super(name);
        prt("子类·调用父类”含一个参数的构造方法“： " + "his name is " + name);
    }

    Chinese(String name, int age) { // 调用具有相同形参的构造方法（3）
        this(name);
        prt("子类：调用子类具有相同形参的构造方法：his age is " + age);
    }

    @Test
    void chineseCon() {
        Chinese cn = new Chinese();
        cn = new Chinese("codersai");
        cn = new Chinese("codersai", 18);
    }
}