package com.yzq.javaio;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

/**
 * Created time 2021/2/28 16:44
 *
 * @author Yangzhengqian
 */
 class InetTest {
    @Test
     void showDemo() {

    }

    @Test
     void testSocket() throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        System.out.println(host.getHostName());
        System.out.println(ip);
    }

    @Test
     void testPing() throws IOException {
        Process p = Runtime.getRuntime().exec("ping " + "https://www.bidianer.com");
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), Charset.forName("GBK")));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.length() != 0) {
                sb.append(line).append("\r\n");
            }
        }
        System.out.println("本次指令返回的消息是：");
        System.out.println(sb);
        Assertions.assertEquals(0,0);
    }
}
