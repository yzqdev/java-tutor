package com.yzq.staticmethod;

import org.junit.jupiter.api.Test;

/**
 * 得出以下总结：
 * <p>1. 当调用JAVA子类的无参构造函数时，虽然子类无参构造函数没有显式调用其父类的无参构造函数，但是Java会自动调用其父类的无参构造器 （注：有参构造函数需要显式调用)</p>
 * <p>2. JAVA的执行顺序是：父类静态变量-> 父类静态块 -> 子类静态变量 -> 子类静态块 -> 父类成员变量 -> 父类构造块 -> 父类构造函数 -> 子类成员变量 -> 子类构造块 -> 子类构造函数</p>
 */
public class StaticTest {
    @Test
    void mainMethod() {

        HelloB bb = new HelloB();
    }
}

class HelloA {
    public HelloA() {
        System.out.println("constructor HelloA");
    }

    {
        System.out.println("I'm A class");
    }
    static {
        System.out.println("static A");
    }
}

class HelloB extends HelloA {
    public HelloB() {
        System.out.println("constructor HelloB");
    }

    {
        System.out.println("I'm B class");
    }
    static {
        System.out.println("static B");
    }

    public static void toB(){
        new HelloB();
    }
}