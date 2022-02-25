package com.yzq.generictest;

import java.util.*;

/**
 * 通用测试
 *E - Element (在集合中使用，因为集合中存放的是元素)<br>
 * T - Type（Java 类）<br>
 * K - Key（键）<br>
 * V - Value（值）<br>
 * N - Number（数值类型）<br>
 * ？ - 表示不确定的 java 类型<br>
 * @author yanni
 * @date 2021/11/30
 */
public class GenericTest {
     
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        List<Integer> age = new ArrayList<>();
        List<Number> number = new ArrayList<>();
        
        name.add("icon");
        age.add(18);
        number.add(314);
 
        //getUperNumber(name);//1
        getUperNumber(age);//2
        getUperNumber(number);//3
       
   }
 
   public static void getData(List<?> data) {
      System.out.println("data :" + data.get(0));
   }
   
   public static void getUperNumber(List<? extends Number> data) {
          System.out.println("data :" + data.get(0));
       }
}