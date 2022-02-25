package com.yzq.thisfunc;

import org.junit.jupiter.api.Test;

/**
 * @Author: Yangzhengqian
 * @Description:
 * @Date:Created time 2019/6/9 08:11
 * @Modified By:
 */
public class This2 {
    String name;
    float hp;
    float armor;
    int movespeed;

    public This2() {

    }

    public void huixue(int xp) {
        hp = hp + xp;
        xp = 0;
    }

    private This2(String name, float hp) {
        this.name = name;
        this.hp = hp;
    }

    public void revive(This2 h) {
        h = new This2("timo", 363);
    }

    @Test
    void testFunc2() {
        This2 teemo = new This2("timo", 382);
        teemo.hp = teemo.hp - 400;
        teemo.revive(teemo);
        System.out.println(teemo.hp);
    }
}
