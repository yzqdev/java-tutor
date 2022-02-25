package com.yzq.entity.charactor;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Yangzhengqian
 * @Description:
 * @Date:Created time 2019/6/9 08:41
 * @Modified By:
 */

@Data
@NoArgsConstructor
public class Hero implements Comparable<Hero> {


    private static final Hero INSTANCE = new Hero();
    /**
     * 表示这个类当前的版本，如果有了变化，比如新设计了属性，就应该修改这个版本号
     */
    public String name;
    public Object o;

    public float hp;
    public int damage;
    private static String copyright;


    static {
        System.out.println("初始化 copyright");
        copyright = "版权由Riot Games公司所有";
    }

    public Hero(String name) {
        System.out.println("hero test");
        this.name = name;
    }

    public Hero(String name, float hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    /**
     * 如果血量相等,则相等
     *
     * @param obj 后者
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Hero) {
            Hero h = (Hero) obj;
            return this.hp == h.hp;
        }
        return false;
    }

    public void useItem(Item item) {
        System.out.println("hero use item");
        item.effect();
    }

    public Hero getInstance() {
        return INSTANCE;
    }

    @Override
    public int compareTo(Hero anotherhero) {
        if (damage < anotherhero.damage) {
            return 1;
        } else {
            return -1;
        }
    }

    public void attackHero(Hero h) {
        try {
            //为了表示攻击需要时间，每次攻击暂停1000毫秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        h.hp -= damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);

        if (h.isDead()) {
            System.out.println(h.name + "死了！");
        }
    }

    public boolean isDead() {
        return 0 >= hp;
    }
}