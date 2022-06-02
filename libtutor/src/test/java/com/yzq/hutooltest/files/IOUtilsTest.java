package com.yzq.hutooltest.files;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.lang.Console;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * @author yanni
 * @date time 2022/6/2 12:12
 * @modified By:
 */
 class IOUtilsTest {
    @Test
    void copyFunc(){
        BufferedInputStream in = FileUtil.getInputStream(Paths.get("src/test/resources/test/a.txt"));
        BufferedOutputStream out = FileUtil.getOutputStream(Paths.get("src/test/resources/test/a2.txt"));
        long copySize = IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);
    }
    @Test
    void getFileType(){
        File file = FileUtil.file(Paths.get("src/test/resources/test/a.txt").toFile());
        String type = FileTypeUtil.getType(file);

        Console.log(type);
    }

    @Test
    void getClassResource(){
        ClassPathResource resource = new ClassPathResource("test.txt");

        Console.log("Properties: {}", IoUtil.read(resource.getStream() ));
    }
}
