package com.yzq.java8.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author yanni
 * @date time 2021/10/16 11:56
 * @modified By:
 */

@Data
@AllArgsConstructor
class Student {
    private String name;
    private int age;
    private Integer score;

    //省略 construct get set

}

 class OptionalExample {
     List<Student> initData() {
        Student s1 = new Student("张三", 19, 80);
        Student s2 = new Student("李四", 19, 50);
        Student s3 = new Student("王五", 23, null);
        Student s4 = new Student("赵六", 16, 90);
        Student s5 = new Student("钱七", 18, 99);
        Student s6 = new Student("孙八", 20, 40);
        Student s7 = new Student("吴九", 21, 88);

        return Arrays.asList(s1, s2, s3, s4, s5, s6, s7);
    }

    @Test
    void sayStr() {
        System.out.println("哈哈哈哈");
    }

    @Test
     void beforeJava8() {
        List<Student> studentList = initData();

        for (Student student : studentList) {
            if (student != null) {
                if (student.getAge() >= 18) {
                    Integer score = student.getScore();
                    if (score != null && score > 80) {
                        System.out.println("入选：" + student.getName());
                    }
                }
            }
        }
    }

    @Test
     void useJava8() {
        List<Student> studentList = initData();
        for (Student student : studentList) {
            Optional<Student> studentOptional = Optional.of(student);
            Integer score = studentOptional.filter(s -> s.getAge() >= 18).map(Student::getScore).orElse(0);

            if (score > 80) {
                System.out.println("入选：" + student.getName());
            }
        }
    }

    @Test
    void getNullDefault() {
        String[] strs = {"zhangsan", "kli", null, "noname", "ayaka"};
        for (String s : strs) {
            Optional<String> optionalS = Optional.ofNullable(s);
            System.out.println(optionalS.orElse("nullData"));
        }
    }
}
