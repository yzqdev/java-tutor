package com.yzq.java8.optional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yanni
 * @date time 2021/10/16 11:36
 * @modified By:
 */
 class OptionalTest {
     Integer sum(Optional<Integer> a, Optional<Integer> b){

        // Optional.isPresent - 判断值是否存在

        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());

        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(0);
        Integer value2 = 0;
        //Optional.get - 获取值，值需要存在
        if (b.isPresent()){
            value2  = b.get();
        }
        return value1 + value2;
    }
    @Test
     void optional1(){
        OptionalTest optionalTest=new  OptionalTest();
        Integer value1 = null;
        Integer value2 = 10;

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(optionalTest.sum(a,b));
    }
    @Test
     void test_createsEmptyOptionalObject() throws Exception {
        Optional<Object> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }

    @Test
     void test_createOptionalObjectWithStaticMethod() {
        String val = "not null";
        Optional<String> hasVal = Optional.of(val);
        assertTrue(hasVal.isPresent());
    }

    @Test
     void test_processOptionalValue() {
        String val = "not null";
        Optional<String> hasVal = Optional.of(val);
        System.out.println(hasVal);
        assertEquals("Optional[not null]", hasVal.toString());
    }

    @Test
     void test_passNullParamNoException() {
        String val = null;
        Optional<String> hasVal = Optional.ofNullable(val);
        assertFalse(hasVal.isPresent());
    }

    @Test
     void test_checkValuePresentOrNotJava11() throws Exception {
        Optional<String> opt = Optional.of("has value");
        assertFalse(opt.isEmpty());

        opt = Optional.ofNullable(null);
        assertTrue(opt.isEmpty());
    }

    @Test
     void doSomeThingWhenExist() throws Exception {
        Optional<String> opt = Optional.of("baeldung");
        opt.ifPresent(name -> System.out.println(name.length()));
    }

    @Test
     void test_getValueUseorElse() throws Exception {
        Optional<String> hasVal = Optional.of("Hello");
        String val = hasVal.orElse("no value");
        System.out.println(val);
        assertEquals("Hello", val);
    }

    @Test
     void test_getValueUseorElseget() throws Exception {
        Optional<String> hasVal = Optional.of("Hello");
        String val = hasVal.orElseGet(() -> "no value");
        assertEquals("Hello", val);
    }

    @Test
    void getText() {
        String val = Optional.of("").orElse("noval");
        System.out.println(val);
    }

    private String getDefaultValue() {
        System.out.println("enter method get default value");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "default value";
    }

    @Test
     void test_differenceOrElseAndorElseGet() throws Exception {
        Optional<String> hasVal = Optional.of("value");
        System.out.println("enter orElse method");
        String var0 = hasVal.orElse(getDefaultValue());
    }

    @Test
     void test_mapList2ListSize() {
        List<String> companyNames = Arrays.asList(
                "Java", "C++", "", "C", "", "Python");
        Optional<List<String>> listOptional = Optional.of(companyNames);

        int size = listOptional
                .map(List::size)
                .orElse(0);
        assertEquals(6, size);
    }

}
