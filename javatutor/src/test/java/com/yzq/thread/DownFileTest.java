package com.yzq.thread;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author yanni
 * @date time 2022/1/25 6:28
 * @modified By:
 */
public class DownFileTest {

    public static void main(String[] args) {
        MyDownloadThread t1 = new MyDownloadThread("https://mvnrepository.com/assets/images/392dffac024b9632664e6f2c0cac6fe5-logo.png", "d:/tmp/1.jpg");
        MyDownloadThread t2 = new MyDownloadThread("https://mvnrepository.com/assets/images/392dffac024b9632664e6f2c0cac6fe5-logo.png", "d:/tmp/2.jpg");
        MyDownloadThread t3 = new MyDownloadThread("https://mvnrepository.com/assets/images/392dffac024b9632664e6f2c0cac6fe5-logo.png", "d:/tmp/3.jpg");
         new Thread(t1).start();
         new Thread(t2).start();
         new Thread(t3).start();
    }
}

class MyDownloadThread implements Runnable {
    Thread t;
    private final String url;
    private final String file;

    public MyDownloadThread(String url, String file) {
        this.url = url;
        this.file = file;

    }

    @Override
    public void run() {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(file));
            System.out.println("下载完成"+file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

