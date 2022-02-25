package com.yzq.myannotion.classAnnote;

/**
 * @author yanni
 */
public class AnnotationTest {
    public static void main(String[] args) {
        try {
            //获取Person的Class对象
            Person person = Person.builder().build();
            Class<? extends Person> clazz = person.getClass();
            //判断person对象上是否有Info注解
            if (clazz.isAnnotationPresent(Info.class)) {
                System.out.println("Person类上配置了Info注解！");
                //获取该对象上Info类型的注解
                Info infoAnno = (Info) clazz.getAnnotation(Info.class);
                System.out.println("person.name :" + infoAnno.value() + ",person.isDelete:" + infoAnno.isDelete());
            } else {
                System.out.println("Person类上没有配置Info注解！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

