package com.yzq.entity.charactor;

/**
 * @Author: Yangzhengqian
 * @Description:
 * @Date:Created time 2019/6/29 11:10
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        Hero h=new Hero();
        Hero h2;
        h.name="hailen";
        System.out.println(h.toString());
        for (int i=0;i<1000000;i++){
            h2=new Hero();
        }
    }
}
