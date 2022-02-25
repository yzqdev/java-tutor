package com.yzq.generictest;

import org.junit.jupiter.api.Test;
import com.yzq.entity.charactor.ADHero;
import com.yzq.entity.charactor.APHero;
import com.yzq.entity.charactor.Hero;

import java.util.ArrayList;

/**
 * ArrayList heroList<? extends Hero> 表示这是一个Hero泛型或者其子类泛型<br>
 * heroList 的泛型可能是Hero<br>
 * heroList 的泛型可能是APHero<br>
 * heroList 的泛型可能是ADHero<br>
 * 所以 可以确凿的是，从heroList取出来的对象，一定是可以转型成Hero的<br>
 * <p>
 * 但是，不能往里面放东西，因为<br>
 * 放APHero就不满足 ADHero <br>
 * 放ADHero又不满足 APHero <br>
 * <pre>
 * E - Element (在集合中使用，因为集合中存放的是元素)
 * T - Type（Java 类）
 * K - Key（键）
 * V - Value（值）
 * N - Number（数值类型）
 * ？ - 表示不确定的 java 类型
 * </pre>
 * @author yanni
 * @date time 2021/10/15 14:43
 * @modified By:
 */
public class GenericExtends {
    @Test
    void extendsTest() {

        ArrayList<APHero> apHeroList = new ArrayList<>();
        apHeroList.add(new APHero());

        ArrayList<? extends Hero> heroList = apHeroList;

        //? extends HeroCompare 表示这是一个Hero泛型的子类泛型

        //heroList 的泛型可以是Hero
        //heroList 的泛型可以使APHero
        //heroList 的泛型可以使ADHero

        //可以确凿的是，从heroList取出来的对象，一定是可以转型成Hero的

        Hero h = heroList.get(0);

        //但是，不能往里面放东西
       // heroList.add(new ADHero()); //编译错误，因为heroList的泛型 有可能是APHero
    }
    //ArrayList heroList<? super HeroCompare> 表示这是一个Hero泛型或者其父类泛型
    //        heroList的泛型可能是Hero
    //heroList的泛型可能是Object
    //
    //        可以往里面插入Hero以及Hero的子类
    //但是取出来有风险，因为不确定取出来是Hero还是Object
    @Test
    void superTest(){
        ArrayList<? super Hero> heroList = new ArrayList<Object>();

        //? super HeroCompare 表示 heroList的泛型是Hero或者其父类泛型

        //heroList 的泛型可以是Hero
        //heroList 的泛型可以是Object

        //所以就可以插入Hero
        heroList.add(new Hero());
        //也可以插入Hero的子类
        heroList.add(new APHero());
        heroList.add(new ADHero());

        //但是，不能从里面取数据出来,因为其泛型可能是Object,而Object是强转Hero会失败
        //HeroCompare h= heroList.get(0);
    }
    @Test
    void question(){
        ArrayList<APHero> apHeroList = new ArrayList<>();

        //?泛型通配符，表示任意泛型
        ArrayList<?> generalList = apHeroList;

        //?的缺陷1： 既然?代表任意泛型，那么换句话说，你就不知道这个容器里面是什么类型
        //所以只能以Object的形式取出来
        Object o = generalList.get(0);

        //?的缺陷2： 既然?代表任意泛型，那么既有可能是Hero,也有可能是Item
        //所以，放哪种对象进去，都有风险，结果就什么什么类型的对象，都不能放进去

        //generalList.add(new Item()); //编译错误 因为?代表任意泛型，很有可能不是Item
        //generalList.add(new HeroCompare()); //编译错误 因为?代表任意泛型，很有可能不是Hero
        //generalList.add(new APHero()); //编译错误  因为?代表任意泛型，很有可能不是APHero
    }
    //
    //如果希望只取出，不插入，就使用? extends HeroCompare
    //如果希望只插入，不取出，就使用? super HeroCompare
    //如果希望，又能插入，又能取出，就不要用通配符？
}
