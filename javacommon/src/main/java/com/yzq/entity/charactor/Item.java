package com.yzq.entity.charactor;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanni
 */
@Data
@NoArgsConstructor
public class Item {
    int price;
    String name;


    //提供一个初始化name的构造方法
    public Item(String name) {
        this.name = name;
    }

    public void effect() {
        System.out.println("物品" + price + "使用后，可以有效果");
    }

}