package com.yzq.javaio;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Yangzhengqian
 * @description
 * @date:Created time 2021/8/20 9:11
 * @modified By:
 */

public class Props {

    @Test
    public void getProps() {
        Properties p = new Properties();
        try {
            p.load(getClassLoader().getResourceAsStream("app.properties"));
            String name = p.getProperty("name");
            System.out.println(p.containsKey("name"));
            System.out.println(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ClassLoader getClassLoader() {
        ClassLoader ret = Thread.currentThread().getContextClassLoader();
        return ret != null ? ret : getClass().getClassLoader();
    }

    @Test
    public void getLinuxSo() {
        try {
            System.load("game");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
