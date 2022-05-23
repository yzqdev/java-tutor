package com.yzq.javaio;

import cn.hutool.core.lang.Console;
import cn.hutool.log.LogFactory;
import cn.hutool.log.StaticLog;
import cn.hutool.log.dialect.console.ConsoleColorLogFactory;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
FileNioTest(){
    //LogFactory.setCurrentLogFactory(ConsoleColorLogFactory.class);
}
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
        System.out.println(path.toAbsolutePath());
        System.out.println();
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
        Console.log("文件存在?{}",Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}));
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


    public static String pathname = "src/test/temp/read.txt";
    public static String filename = "src/test/temp/write.txt";

    @Test
    void readAndWrite() throws IOException {
        readNIO();
        writeNIO();
        //testReadAndWriteNIO();
    }

    public static void readNIO() {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(pathname);
            FileChannel channel = fin.getChannel();

            int capacity = 50;// 字节
            ByteBuffer bf = ByteBuffer.allocate(capacity);
            System.out.println("限制是：" + bf.limit() + ",容量是：" + bf.capacity() + " ,位置是：" + bf.position());
            int length = -1;

            while ((length = channel.read(bf)) != -1) {

                /*
                 * 注意，读取后，将位置置为0，将limit置为容量, 以备下次读入到字节缓冲中，从0开始存储
                 */
                bf.clear();
                byte[] bytes = bf.array();
                System.out.println("start..............");

                String str = new String(bytes, 0, length);
                System.out.println(str);
                System.out.write(bytes, 0, length);

                System.out.println("end................");

                System.out.println("限制是：" + bf.limit() + "容量是：" + bf.capacity() + "位置是：" + bf.position());

            }

            channel.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writeNIO() {
        FileOutputStream fos = null;
        try {

            fos = new FileOutputStream(filename);
            FileChannel channel = fos.getChannel();
            ByteBuffer src = StandardCharsets.UTF_8.encode("你好你好你好你好你好");
            // 字节缓冲的容量和limit会随着数据长度变化，不是固定不变的
            System.out.println("初始化容量和limit：" + src.capacity() + ","
                    + src.limit());
            int length;

            while ((length = channel.write(src)) != 0) {
                /*
                 * 注意，这里不需要clear，将缓冲中的数据写入到通道中后 第二次接着上一次的顺序往下读
                 */
                System.out.println("写入长度:" + length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void testReadAndWriteNIO() {
        FileInputStream fin = null;
        FileOutputStream fos = null;
        try {
            fin = new FileInputStream(new File(pathname));
            FileChannel channel = fin.getChannel();

            int capacity = 100;// 字节
            ByteBuffer bf = ByteBuffer.allocate(capacity);
            System.out.println("限制是：" + bf.limit() + "容量是：" + bf.capacity() + "位置是：" + bf.position());
            int length = -1;

            fos = new FileOutputStream(new File(filename));
            FileChannel outchannel = fos.getChannel();


            while ((length = channel.read(bf)) != -1) {

                //将当前位置置为limit，然后设置当前位置为0，也就是从0到limit这块，都写入到同道中
                bf.flip();

                int outlength = 0;
                while ((outlength = outchannel.write(bf)) != 0) {
                    System.out.println("读，" + length + "写," + outlength);
                }

                //将当前位置置为0，然后设置limit为容量，也就是从0到limit（容量）这块，
                //都可以利用，通道读取的数据存储到
                //0到limit这块
                bf.clear();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    void listAllFiles(Path path) {

    }
}
