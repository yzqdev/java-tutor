package com.yzq.javaio;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * <p><img src='https://www.runoob.com/wp-content/uploads/2013/12/iostream2xx.png' /></p>
 * @author Yangzhengqian
 * @date time 2019/6/9 13:52
 * @Modified By:
 */
public class DatastreamTest {
    /**
     *
     * 数据输出流允许应用程序以与机器无关方式将Java基本数据类型写到底层输出流。
     * @see <a href='https://www.runoob.com/java/java-scanner-class.html' >链接</a>
     */
    @Test
    void readDatasteam() {
        writeDatasteam();

        try (FileInputStream fis = (FileInputStream) FileUtil.getFileAsSteam("txt/lol6.txt"); DataInputStream dis = new DataInputStream(fis)) {
            boolean b = dis.readBoolean();
            int i = dis.readInt();
            String str = dis.readUTF();
            System.out.println("读取到布尔值:" + b);
            System.out.println("读取到整数:" + i);
            System.out.println("读取到字符串:" + str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void writeDatasteam() {
        try (FileOutputStream fos = (FileOutputStream) FileUtil.setFileAsSteam("txt/lol6.txt"); DataOutputStream dos = new DataOutputStream(fos)) {
            dos.writeBoolean(true);
            dos.writeInt(300);
            dos.writeUTF("123 this is gareen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
