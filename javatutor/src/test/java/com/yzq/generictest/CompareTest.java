package com.yzq.generictest;

import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * @author yanni
 */
@ToString
class HeroCompare implements Comparable<HeroCompare> {
    //表示这个类当前的版本，如果有了变化，比如新设计了属性，就应该修改这个版本号
    public String name;
    public float hp;
    public int damage;



    public HeroCompare(String name, float hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }



    @Override
    public int compareTo(HeroCompare anotherhero) {
        if (damage> anotherhero.damage) {
            return 1;
        } else {
            return -1;
        }
    }


}
public class CompareTest {
    @Test
    void testCompare() {
        HeroCompare h1 = new HeroCompare("1", 10, 50);
        HeroCompare h2 = new HeroCompare("2", 20, 20);
        HeroCompare h3 = new HeroCompare("3", 30, 30);
        HeroCompare[] heroes = {h1, h2, h3};
        Arrays.sort(heroes);
        Arrays.stream(heroes).forEach(System.out::println);
    }
}
