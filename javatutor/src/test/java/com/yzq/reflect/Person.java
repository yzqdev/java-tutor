package com.yzq.reflect;

import lombok.Data;
import com.yzq.entity.charactor.Hero;


@Data
public class Person {
    public String name = "person name";
    public int age;
    public Hero hero;

    public String cry() {
        return "呜呜呜";
    }
}
