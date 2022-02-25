package com.yzq.thisfunc;


import org.junit.jupiter.api.Test;

/**
 * @author yanni
 */
class GaintDragon {


    private static final GaintDragon instance = new GaintDragon();

    public static GaintDragon getInstance() {
        return instance;
    }
}

/**
 * 捷安特drgon测试
 *
 * @author yanni
 * @date 2022/01/06
 */
public class GaintDragonTest {
    @Test
    void gaintDrgon() {
        GaintDragon g1 = GaintDragon.getInstance();
        GaintDragon g2 = GaintDragon.getInstance();

        System.out.println(g1 == g2);
    }
}
