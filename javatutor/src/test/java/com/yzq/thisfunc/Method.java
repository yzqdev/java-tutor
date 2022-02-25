package com.yzq.thisfunc;

import org.junit.jupiter.api.Test;

class Base {
    public String name;

    public Base() {
        name = "jack";
    }

    public Base(String pName) {
        name = pName;
    }

    public void sample() {
        System.out.println(name);
    }
}

class Children extends Base {
    public Children() {
        super("child1");
        name = "child2";
    }
}

public class Method {
    @Test
    void child() {
        Children c = new Children();
        c.sample();
    }
}