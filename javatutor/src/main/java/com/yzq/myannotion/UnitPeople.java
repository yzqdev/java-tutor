package com.yzq.myannotion;

import java.lang.reflect.Field;

/**
 * @Author: Yangzhengqian
 * @Description:
 * @Date:Created time 2020/7/23 20:43
 * @Modified By:
 */
public class UnitPeople {
    @MyField(description = "hell", length = 2)
    String name = "hello";
    @MyField(description = "age", length = 4)
    int age = 10;

    public UnitPeople() {
        Class<UnitPeople> clazz = UnitPeople.class;
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(MyField.class)) {
                MyField annotation = field.getDeclaredAnnotation(MyField.class);

                System.out.println(clazz.getName() + " getFieldname " + field.getName());
                System.out.println(clazz.getName() + "unitPeople getDescription " + annotation.description());
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
