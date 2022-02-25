package com.yzq;

import org.junit.jupiter.api.Test;

/**enum可以有get set方法,构造方法
 * @author yanni
 * @date time 2021/10/17 18:04
 * @modified By:
 */
interface Behaviour {
    void print();

    String getInfo();
}

enum Fruits implements Behaviour {
    apple("苹果", 1),
    banana("橡胶", 3),
    orange("橘子", 3),
    pear("梨", 5),
    peach("桃子", 7),
    watermelon("西瓜", 6),
    grape("葡萄", 9);


    Fruits(String name, int size) {
        this.name = name;
        this.size = size;
    }

    private String name;
    private int size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    @Override
    public String toString() {
        return "Fruits{" +
                "name='" + name + '\'' +
                ", size=" + size +
                "} " + super.toString();
    }

    @Override
    public void print() {
        System.out.println(this.name + this.size);
    }

    @Override
    public String getInfo() {
        return null;
    }
}

public class EnumTest {

    @Test
    void enumTest1() {
        System.out.println(Fruits.apple);
        System.out.println("name=" + Fruits.apple.name() + ",ordinal=" + Fruits.apple.ordinal());
        System.out.println(Fruits.apple.getDeclaringClass());
        System.out.println(Fruits.apple);
    }

    @Test
    void useSwitch() {
        Fruits app = Fruits.apple;

        switch (app) {
            case apple:
                app = Fruits.apple;
                break;
            case grape:
                app = Fruits.grape;
                break;
            case pear:
                app = Fruits.pear;
                break;
        }

    }
}
