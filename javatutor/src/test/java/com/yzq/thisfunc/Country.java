package com.yzq.thisfunc;

import org.junit.jupiter.api.Test;

public class Country {
    String name;

    void value() {
        name = "China";
    }
}

/**
 * 城市
 *
 * @author yanni
 * @date 2022/01/06
 */
class City extends Country {
    String name;

    @Override
    void value() {
        name = "Shanghai";
        super.value();      //调用父类的方法
        System.out.println(name);
        System.out.println(super.name);
    }

    @Test
    void testCity() {
        City c = new City();
        c.value();
    }
}