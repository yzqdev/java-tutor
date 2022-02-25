package com.yzq.myannotion;

public class TestReflection {

    public static void main(String[] args) {
        String className = "UnitPeople";
        UnitPeople people = new UnitPeople();
        MyFieldTest fieldTest = new MyFieldTest();
        fieldTest.testMyField();
    }
}
