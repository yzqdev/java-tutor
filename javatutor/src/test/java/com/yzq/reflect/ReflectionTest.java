package com.yzq.reflect;

import org.junit.jupiter.api.Test;
import com.yzq.entity.charactor.Hero;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * @author yanni
 * @date time 2021/10/15 17:34
 * @modified By: yzq
 */
public class ReflectionTest {
    @Test
    void test1() {
        String className = "yzq.charactor.HeroCompare";
        try {
            Class<?> pClass1 = Class.forName(className);
            Class<Hero> pClass2 = Hero.class;
            Class<? extends Hero> pClass3 = new Hero().getClass();
            System.out.println(pClass1 == pClass2);
            System.out.println(pClass1 == pClass3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testReflect1() {
        String className = "yzq.charactor.HeroCompare";
        try {
            Class<?> p1 = Class.forName(className);
            Class<Hero> p2 = Hero.class;
            System.out.println(p1);
            System.out.println(p2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void addnew() {
        //传统的使用new的方式创建对象
        Hero h1 = new Hero();
        h1.name = "teemo";
        System.out.println(h1);

        try {
            //使用反射的方式创建对象
            String className = "yzq.charactor.Customer";
            //类对象
            Class<?> pClass = Class.forName(className);
            //构造器
            Constructor<?> c = pClass.getConstructor();
            System.out.println("gun");
            System.out.println(c);
            //通过构造器实例化
            Hero h2 = (Hero) c.newInstance();
            h2.name = "gareen";
            System.out.println(h2);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    void getProp() {
        Hero h = new Hero();
        //使用传统方式修改name的值为garen
        h.name = "garen";
        try {
            //获取类Hero的名字叫做name的字段
            Field f1 = h.getClass().getDeclaredField("name");
            //修改这个字段的值
            f1.set(h, "teemo");
            //打印被修改后的值
            System.out.println(h.name);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * getField和getDeclaredField的区别<br>
     * 这两个方法都是用于获取字段<br>
     * getField 只能获取public的，包括从父类继承来的字段。<br>
     * getDeclaredField 可以获取本类所有的字段，包括private的，但是不能获取继承来的字段。 (注： 这里只能获取到private的字段，但并不能访问该private字段的值,除非加上setAccessible(true))<br>
     */
   @Test
    void getMethodName() {
        Hero h = new Hero();

        try {
            // 获取这个名字叫做setName，参数类型是String的方法
            Method m = h.getClass().getMethod("setName", String.class);
            // 对h对象，调用这个方法
            Parameter[] parameters = m.getParameters();
            String[] parameterNames = new String[parameters.length];
            System.out.println("parameternames");
            System.out.println(Arrays.toString(parameters));
            for (int i = 0; i < parameters.length; i++) {
                Parameter param = parameters[i];
                if (!param.isNamePresent()) {
                    System.out.println("kong");
                }
                System.out.println(param.getName());
                System.out.println("这是参数");
                parameterNames[i] = param.getName();
            }
            m.invoke(h, "盖伦");
            // 使用传统的方式，调用getName方法
            System.out.println(h.getName());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    void getPersonName(){
        try {
             Person c=new  Person();
            Class<? extends Person> p=  Person.class;

            Field fname=p.getDeclaredField("name");
            Field fhero=p.getDeclaredField("hero");
            Method m=p.getDeclaredMethod("cry");
            m.invoke(new Person());
            System.out.println(fhero.getName());
            System.out.println(fhero.getType());
            Object value=fname.get(c);
            System.out.println(value);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
