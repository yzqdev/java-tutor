package com.yzq;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author yanni
 * @date time 2021/10/14 11:53
 * @modified By:
 */
public class SocketTest {
    @Test
     void testSocket() throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        System.out.println(host.getHostName());
        System.out.println(ip);
    }

    @Test
      void testPing() throws IOException {
        Process p = Runtime.getRuntime().exec("ping " + "http://www.baidu.com");
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.length() != 0) {
                sb.append(line).append("\r\n");
            }
        }
        System.out.println("本次指令返回的消息是：");
        System.out.println(sb);
    }
}
