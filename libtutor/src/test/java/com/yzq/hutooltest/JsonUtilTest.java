package com.yzq.hutooltest;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author yanni
 * @date time 2022/5/24 7:48
 * @modified By:
 */
public class JsonUtilTest {
    @Test
    void jsonTest(){
        SortedMap<Object, Object> sortedMap = new TreeMap<>() {
            private static final long serialVersionUID = 1L;

            {
                put("attributes", "a");
                put("b", "b");
                put("c", "c");
            }
        };

      String jStr=  JSONUtil.toJsonStr(sortedMap);
        Console.log(jStr);
        Console.log(JSONUtil.toJsonPrettyStr(sortedMap));
        String html = "{\"name\":\"Something must have been changed since you leave\"}";
        JSONObject jsonObject = JSONUtil.parseObj(html);
       String name= jsonObject.getStr("name");
        Console.log(name);
    }
    @Test
    void jsonObj(){
        String jsonStr = "{\"b\":\"value2\",\"c\":\"value3\",\"a\":\"value1\"}";
//方法一：使用工具类转换
        JSONObject jsonObject = JSONUtil.parseObj(jsonStr);
//方法二：new的方式转换
        JSONObject jsonObject2 = new JSONObject(jsonStr);

    }
@Data
static
class Seq{
        private  String name;
        private  String value;
        Seq(String name,String value ){
            this.name=name;
             this.value=value;
        }
}
    @Data
      static class UserA {
        private String name;
        private String a;
        private Date date;
        private List<Seq> sqs;
    }
    @Test
    void getUser(){
        UserA userA = new UserA();
        userA.setName("nameTest");
        userA.setDate(new Date());
        userA.setSqs(CollectionUtil.newArrayList(new Seq(null,"val"), new Seq("seq2","seqval")));

// false表示不跳过空值
        JSONObject json = JSONUtil.parseObj(userA, false);
        Console.log(json.toStringPretty());
    }

    @Test
    void jsonArr(){
        //方法1
        JSONArray array1 = JSONUtil.createArray();
//方法2
        JSONArray array = new JSONArray();

        array.add("value1");
        array.add("value2");
        array.add("value3");

//转为JSONArray字符串
        Console.log(array.toString());
    }
}
