package com.yzq.employer;

import lombok.Builder;
import lombok.Data;

/* 文件名 : Employee.java */
@Data

@Builder
public class Employee {
    private String name;
    private String address;
    private int number;

    Employee(String name, String address, int number) {
        System.out.println("Employee 构造函数");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public void mailCheck() {
        System.out.println("邮寄支票给： " + this.name
                + " " + this.address);
    }


}