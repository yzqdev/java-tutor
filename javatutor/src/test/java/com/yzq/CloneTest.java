package com.yzq;

import org.junit.jupiter.api.Test;

class CloneTest implements Cloneable {
    int rollno;
    String name;

    CloneTest(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Test
    void cloneTest() {
        try {
            CloneTest s1 = new CloneTest(101, "amit");

            CloneTest s2 = (CloneTest) s1.clone();

            System.out.println(s1.rollno + " " + s1.name);
            System.out.println(s2.rollno + " " + s2.name);

        } catch (CloneNotSupportedException ignored) {
        }

    }
}

