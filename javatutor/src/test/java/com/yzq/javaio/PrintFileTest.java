package com.yzq.javaio;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * 打印文件
 *
 * @author yanni
 * @date 2022/01/03
 */
class PrintFileTest {
    @Test
     void showFolderFiles(){
        File f = new File("C:\\Windows");
        File[] fs1 = f.listFiles(); // 列出所有文件和子目录
        printFiles(fs1);
        // 仅列出.exe文件
        File[] fs2 = f.listFiles((dir, name) -> {
            return name.endsWith(".exe"); // 返回true表示接受该文件
        });
        printFiles(fs2);
    }

    static void printFiles(File[] files) {
        System.out.println("==========");
        if (files != null) {
            for (File f : files) {
                System.out.println(f);
            }
        }
        System.out.println("==========");
    }
}
