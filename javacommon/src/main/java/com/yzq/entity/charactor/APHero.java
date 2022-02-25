package com.yzq.entity.charactor;

/**
 * @Author: Yangzhengqian
 * @Description:
 * @Date:Created time 2019/6/9 08:46
 * @Modified By:
 */


public class APHero extends Hero implements AP {
    @Override
    public void magicAttack() {
        System.out.println("magic attack");
    }
}
