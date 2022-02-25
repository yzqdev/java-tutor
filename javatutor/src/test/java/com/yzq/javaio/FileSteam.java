package com.yzq.javaio;

import org.junit.jupiter.api.Test;
import com.yzq.entity.charactor.Customer;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author yanni
 * @date time 2021/10/14 9:16
 * @modified By:
 */
public class FileSteam {
    /**
     * 二进制输出,可能有乱码
     */
    @Test
    public void fileSteam1() {
        //System.out.println(System.getProperty("java.io.tmpdir"));
        try {
            byte[] bWrite = {65,66,67,69,70};
            String path="txt/test.txt";

            OutputStream os = FileUtil.setFileAsSteam(path);
            //OutputStream os = new FileOutputStream(file);
            for (byte b : bWrite) {
                os.write(b);
                // writes the bytes
            }
            os.close();

            InputStream is =FileUtil.getFileAsBufferSteam("txt/test.txt");
            int size = is.available();

            for (int i = 0; i < size; i++) {
                System.out.print((char) is.read() + "  ");
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     * 解决乱码问题
     */
    @Test
    public void fileSteam2() {
        try {

            File f = new File("txt/a.txt");
            FileOutputStream fop = (FileOutputStream) FileUtil.setFileAsSteam("txt/a.txt");
            // 构建FileOutputStream对象,文件不存在会自动新建

            OutputStreamWriter writer = new OutputStreamWriter(fop, StandardCharsets.UTF_8);
            // 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk

            writer.append("中文输入");
            // 写入到缓冲区

            writer.append("\r\n");
            // 换行

            writer.append("English");
            // 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入

            writer.close();
            // 关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉

            fop.close();
            // 关闭输出流,释放系统资源

            FileInputStream fip = (FileInputStream) FileUtil.getFileAsSteam("txt/a.txt");
            // 构建FileInputStream对象

            InputStreamReader reader = new InputStreamReader(fip, StandardCharsets.UTF_8);
            // 构建InputStreamReader对象,编码与写入相同

            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                sb.append((char) reader.read());
                // 转成char加到StringBuffer对象中
            }
            System.out.println(sb.toString());
            reader.close();
            // 关闭读取流

            fip.close();
            // 关闭输入流,释放系统资源
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void objSteam() {
        try {
            ObjectOutputStream objectOut = new ObjectOutputStream(new BufferedOutputStream(FileUtil.setFileAsSteam("txt/object.bin")));
            Customer cus = new Customer("wang", "0001", "pddd", 3000);
            objectOut.writeObject(cus);
            objectOut.close();

            ObjectInputStream objectIn = new ObjectInputStream(new BufferedInputStream(FileUtil.getFileAsBufferSteam("txt/object.bin")));
            cus = (Customer) objectIn.readObject();
            System.out.println("Name:" + cus.getName());
            System.out.println("ID:" + cus.getID());
            System.out.println("Password:" + cus.getPassword());
            System.out.println("Salary:" + cus.getSalary());
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
