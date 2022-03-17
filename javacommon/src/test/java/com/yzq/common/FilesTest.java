package com.yzq.common;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author yanni
 * @date time 2022/3/17 17:09
 * @modified By:
 */
public class FilesTest {

    @Test
    public void checkJson() {
        String json = "D:\\games\\mcservers\\mc-dev\\plugins\\colormotd\\config.json";
        Path dataFolder = Path.of(json);
        boolean flat = Files.isRegularFile(dataFolder);
        System.out.println(flat);
    }
}
