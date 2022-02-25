package com.yzq.entity.charactor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Customer implements Serializable {
    private String name, iD;
    transient private String password;
    private float salary;



    public Customer(String name, String iD, String password, float salary) {
        this.name = name;
        this.iD = iD;
        this.password = password;
        this.salary = salary;
    }


};