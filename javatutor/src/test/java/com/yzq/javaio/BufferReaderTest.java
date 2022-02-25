package com.yzq.javaio;

import org.junit.jupiter.api.Test;

import java.io.*;

/**<p><img src='https://www.runoob.com/wp-content/uploads/2013/12/iostream2xx.png' /></p>
 * @author yanni
 * @date time 2021/10/14 11:28
 * @modified By:
 */
public class BufferReaderTest {
    @Test
    void reader1() {
        int[] age = new int[0];
        for (int i : age) {
            System.out.println(i);
        }
        // 准备文件lol.txt其中的内容是
        // garen kill teemo
        // teemo revive after 1 minutes
        // teemo try to garen, but killed again
        File f = new File("/opt/lol.txt");
        // 创建文件字符流
        // 缓存流必须建立在一个存在的流的基础上
        try (
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
        ) {
            while (true) {
                // 一次读一行
                String line = br.readLine();
                if (null == line) {
                    break;
                }

                System.out.println(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    @Test
    void bufferwritesys() {
        File f = new File("/opt/lolfolder/lol3.txt");
        try (FileWriter fw = new FileWriter(f);

             PrintWriter pw = new PrintWriter(fw)
        ) {
            pw.println("garen kill teemo");
            pw.println("teemo revive after 1 min");
            pw.println("teemo try to faren ,but killed again");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    void flushtest() {
        File f = new File("d:/lolfolder/lol2.txt");
        try (FileWriter fr = new FileWriter(f); PrintWriter pw = new PrintWriter(fr)) {
            pw.println("garen kill teemo");
            pw.flush();
            pw.println("teemo revive after 1 min");
            pw.flush();
            pw.println("teemo try to faren ,but killed again");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
