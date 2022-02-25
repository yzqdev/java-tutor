package com.yzq.thisfunc;

import org.junit.jupiter.api.Test;

/**
 * @Author: Yangzhengqian
 * @Description:
 * @Date:Created time 2019/6/8 22:10
 * @Modified By:
 */
public class ThisTest {
    /**
     * 姓名
     */
    String name;
    /**
     * 血量
     */
    float hp;
    /**
     * 护甲
     */
    float armor;
    /**
     * 移动速度
     */
    int moveSpeed;

    /**
     * 带一个参数的构造方法
     *
     * @param name
     */
    public ThisTest(String name) {
        System.out.println("一个参数的构造方法");
        this.name = name;
    }

    /**
     * 带两个参数的构造方法
     *
     * @param name
     * @param hp
     */
    public ThisTest(String name, float hp) {
        this(name);
        System.out.println("两个参数的构造方法");
        this.hp = hp;
    }

    @Test
    void thisFunc() {
        ThisTest teemo = new ThisTest("提莫", 383);

        System.out.println(teemo.name);

    }

}