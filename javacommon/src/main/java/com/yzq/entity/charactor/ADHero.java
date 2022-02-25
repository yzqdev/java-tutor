package com.yzq.entity.charactor;

/**
 * @Author: Yangzhengqian
 * @Description:
 * @Date:Created time 2019/6/9 08:40
 * @Modified By:
 */
public class ADHero extends Hero implements AD {
    @Override
    public void physicAttack() {
        System.out.println("phyics attack");
    }

    public ADHero() {
    }

    public ADHero(String name) {
        super(name);
        System.out.println("AD Hero的构造方法");
    }

    @Override
    public void useItem(Item item) {
        System.out.println("adherouse item");
        System.out.println(super.getName());
        super.useItem(item);
    }

    public static void main(String[] args) {
       ADHero a= new ADHero("helo");
       Item i=new Item("hello");
       a.useItem(i);
    }

}
