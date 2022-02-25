package com.yzq.javaio;


import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.*;
import java.net.URL;
import java.util.List;

/**
 * <p><img src='https://www.runoob.com/wp-content/uploads/2013/12/iostream2xx.png' /></p>
 *
 * @author yanni
 * @date time 2021/10/14 8:40
 * @modified By:
 */
public class FileTest {
    @Test
    void file1() {

        File f = new File("txt/folder");

        // 以字符串数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        f.list();

        // 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        File[] fs = f.listFiles();

        // 以字符串形式返回获取所在文件夹
        f.getParent();

        // 以文件形式返回获取所在文件夹
        f.getParentFile();
        // 创建文件夹，如果父文件夹skin不存在，创建就无效
        f.mkdir();

        // 创建文件夹，如果父文件夹skin不存在，就会创建父文件夹
        f.mkdirs();

        // 创建一个空文件,如果父文件夹skin不存在，就会抛出异常
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 所以创建一个空文件之前，通常都会创建父目录
        f.getParentFile().mkdirs();

        // 列出所有的盘符c: d: e: 等等
        File.listRoots();

        // 刪除文件
        //f.delete();

        // JVM结束的时候，刪除文件，常用于临时文件的删除
        f.deleteOnExit();
    }

    // 删除文件及目录
    public static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }

    @Test
    void simpleCreateFolders() {
        File newFolder = new File("txt/del");
        File newFile = new File("txt/del/d.txt");
        try {

            FileOutputStream outputStream = new FileOutputStream(newFile);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

            outputStreamWriter.append("simple create");
            outputStreamWriter.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!newFolder.exists()) {
            newFolder.mkdirs();
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    void deleteFolders() {

        File folder = new File("txt/del");
        deleteFolder(folder);
    }

    @Test
    public void dirList() {
        String dirname = "txt/tmp";
        File f1 = new File(dirname);
        if (f1.isDirectory()) {
            System.out.println("目录 " + dirname);
            String[] s = f1.list();
            assert s != null;
            for (String value : s) {
                File f = new File(dirname + "/" + value);
                if (f.isDirectory()) {
                    System.out.println(value + " 是一个目录");
                } else {
                    System.out.println(value + " 是一个文件");
                }
            }
        } else {
            System.out.println(dirname + " 不是一个目录");
        }
    }

    @Test
    public void fileTest() {
        File f1 = new File("txt");
        System.out.println(f1.getAbsolutePath());
        File f2 = new File("txt/a.txt");
        System.out.println(f2.getAbsolutePath());
        File f3 = new File(f1, "txt/a.txt");
        System.out.println(f3.getAbsolutePath());
    }

    @Test
    public void fileRead() {
        try {
            File f = new File("txt/lol.txt");
            FileInputStream fis = new FileInputStream(f);
            byte[] all = new byte[(int) f.length()];
            fis.read(all);
            for (byte b : all) {
                System.out.println(b);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("read failure");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void fileWrite() {
        try {
            File f = new File("txt/lol2.txt");
            //这里是ascll码
            byte[] data = {44, 33, 65, 62};
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(data);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void fileReaderTest() {
        File f = new File("txt/lol.txt");
        try (FileReader fr = new FileReader(f)) {
            char[] all = new char[(int) f.length()];
            fr.read(all);
            for (char b : all) {
                System.out.println(b);
                assertEquals(b, b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void fileWriteTest() {
        File f = new File("txt/lol3.txt");
        assertTrue(f.isFile());
        try (FileWriter fr = new FileWriter(f)) {
            String data = "测试filewriter";
            char[] cs = data.toCharArray();
            fr.write(cs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用guava获取resource的文件
     */
    @Test
    void getResourceFile() {
        try {
            URL url = Resources.getResource("test/test.txt");

            List<String> lines = Resources.asCharSource(url, Charsets.UTF_8).readLines();
            System.out.println(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getResourceAsSteam() {

         BufferedInputStream inputStream = (BufferedInputStream) FileUtil.getFileAsBufferSteam("test/test.txt");
        try {
            byte[] buf = new byte[1024];
            assert inputStream != null;
            int len=  inputStream.read(buf) ;
            System.out.println(new String(buf,0,len));
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
