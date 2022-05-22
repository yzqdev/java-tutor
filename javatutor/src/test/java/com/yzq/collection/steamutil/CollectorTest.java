package com.yzq.collection.steamutil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Builder
class Person {
    private String name;
    private String phoneNumber;

}

class CollectorTest {
    @Test
    void shot() {
        List<Person> bookList = new ArrayList<>();
        bookList.add(new Person("jack", "18163138123"));
        bookList.add(new Person("martin", null));
// 空指针异常
      Map books=  bookList.stream().collect(Collectors.toMap(Person::getName, Person::getPhoneNumber));
        System.out.println(books);
    }

    @Test
    void removeIf(){
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; ++i) {
            list.add(i);
        }
        list.removeIf(filter -> filter % 2 == 0); /* 删除list中的所有偶数 */
        System.out.println(list); /* [1, 3, 5, 7, 9] */
        System.out.println(list.stream().toList());
        System.out.println(Arrays.toString(list.toArray()));
        Assertions.assertEquals(1,2-1);
    }
    @Test
    void listToArray(){
        String [] s= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list = Arrays.asList(s);
        Collections.reverse(list);
//没有指定类型的话会报错
        s=list.toArray(new String[0]);
        System.out.println(Arrays.toString(s));
    }
}
