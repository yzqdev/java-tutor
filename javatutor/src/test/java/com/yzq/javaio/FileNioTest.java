package com.yzq.javaio;

import cn.hutool.core.lang.Console;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

/**
 * @author yanni
 * @date time 2022/3/17 17:09
 * @modified By:
 */
class FileNioTest {
    Path path = Paths.get("src/test/java/com/yzq/javaio/FileNioTest.java");

    @Test
    void testRegularFile() {

        System.out.println(Files.isDirectory(path));
        System.out.println(Files.isRegularFile(path));
        System.out.println(Files.isSymbolicLink(path));
        System.out.println(Files.isReadable(path));
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isExecutable(path));
    }

    @Test
    void checkJson() {
        String json = "D:\\games\\mcservers\\mc-dev\\plugins\\colormotd\\config.json";
        Path dataFolder = Path.of(json);
        boolean flat = Files.isRegularFile(dataFolder);
        System.out.println(flat);
    }

    @Test
    void pathTest() {
        Path path = Paths.get("C:\\Windows\\explorer.exe");
        System.out.println("文件名：" + path.getFileName());
        System.out.println("名称元素的数量：" + path.getNameCount());
        System.out.println("父路径：" + path.getParent());
        System.out.println("根路径：" + path.getRoot());
        System.out.println("是否是绝对路径：" + path.isAbsolute());
        //startsWith()方法的参数既可以是字符串也可以是Path对象
        System.out.println("是否是以为给定的路径D:开始：" + path.startsWith("D:\\"));
        System.out.println("该路径的字符串形式：" + path);

    }

    @Test
    void getPath() throws IOException {
        Path currentDir = Paths.get(".");
        System.out.println(currentDir.toAbsolutePath());//输出C:\Users\Administrator\NIODemo\.
        Path currentDir2 = Paths.get(".\\pom.xml");
        System.out.println("原始路径格式：" + currentDir2.toAbsolutePath());
        System.out.println("执行normalize（）方法之后：" + currentDir2.toAbsolutePath().normalize());
        System.out.println("执行toRealPath()方法之后：" + currentDir2.toRealPath());
        //..表示父目录或者说是上一级目录：
        Path currentDir3 = Paths.get("..");
        System.out.println("原始路径格式：" + currentDir3.toAbsolutePath());
        System.out.println("执行normalize（）方法之后：" + currentDir3.toAbsolutePath().normalize());
        System.out.println("执行toRealPath()方法之后：" + currentDir3.toRealPath());
    }

    @Test
    void getAttr() throws IOException {
        Path path = Paths.get("src/test/temp/src.txt");
        System.out.println(Files.getLastModifiedTime(path));
        System.out.println(Files.size(path));
        System.out.println(Files.isSymbolicLink(path));
        System.out.println(Files.isDirectory(path));
        System.out.println(Files.readAttributes(path, "*"));
    }

    @Test
/**
 * 检查给定的Path在文件系统中是否存在
 */
    void checkExist() {
        //true
        Console.log(Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}));
    }

    @Test
    void createFile() {
        Path createFile = Paths.get("src/test/temp/test.txt");
        try {
            if (!Files.exists(createFile.getParent())) {
                Files.createDirectory(createFile.getParent());
                if (!Files.exists(createFile)) {
                    Files.createFile(createFile);
                    Console.log("文件创建成功");


                }
            } else {
                Files.delete(createFile);
                Console.log("文件删除成功");
            }


        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @Test
    void copyTxt() {
        Path src = Paths.get("src/test/temp/src.txt");
        Path dest = Paths.get("src/test/temp/dest.txt");
        try {
            if (Files.exists(src)) {
                Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
                Console.log("文件复制成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历文件夹
     */
    @Test
    void walkOneFolder() {
        Path dir = Paths.get(System.getProperty("user.home"));
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path e : stream) {
                System.out.println(e.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历整个文件目录
     *
     * @throws IOException ioexception
     */
    @Test
void walkFileTree() throws IOException {
    Path startingDir = Paths.get(System.getProperty("user.dir"));
    List<Path> result = new LinkedList<Path>();
    Files.walkFileTree(startingDir, new FindJavaVisitor(result));
    System.out.println("result.size()=" + result.size());
}
    @Test
    void getHome(){
        Console.log(System.getProperty("user.home"));
    }
    private static class FindJavaVisitor extends SimpleFileVisitor<Path>{
        private List<Path> result;
        public FindJavaVisitor(List<Path> result){
            this.result = result;
        }
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
            if(file.toString().endsWith(".java")){
                Console.log(file.getFileName());
                result.add(file.getFileName());
            }
            return FileVisitResult.CONTINUE;
        }
    }
    void listAllFiles(Path path) {

    }
}
