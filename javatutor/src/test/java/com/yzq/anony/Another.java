package com.yzq.anony;


import org.junit.jupiter.api.Test;

interface Polygon {
    void display();

    void second();
}

@FunctionalInterface
interface SinglePolygon {
    void singleSay();
}

class AnonymousDemo {
    @Test
    public void createClass() {

        // 创建的匿名类继承了 Polygon 类
        Polygon p1 = new Polygon() {
            @Override
            public void display() {
                System.out.println("内部类");
            }

            @Override
            public void second() {
                System.out.println("第二个就不行了");
            }
        };
        p1.display();
        SinglePolygon singlePolygon = new SinglePolygon() {
            @Override
            public void singleSay() {
                System.out.println("lambda表达式");
            }
        };//()->System.out.println("lambda");
        singlePolygon.singleSay();
    }
}

