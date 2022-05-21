package com.yzq.java17down;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author yzq
 *
 * @date  time 2021/10/12 14:52
 * @modified By:
 * @since jdk12
 */
 class Java12Test {
    @Test
    void filesTest(){
        Path file1= null;
        try {
            file1 = Files.createTempFile("file1",".txt");
            Files.writeString(file1,"java 12test");
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
