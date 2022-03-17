package com.yzq.http;

import cn.hutool.core.lang.Console;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.lionsoul.ip2region.Util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author yanni
 * @date time 2022/3/17 19:31
 * @modified By:
 */
public class ClientTest {
    private Gson gson = new Gson();

    @Test
    public void testGet() {
        // 创建 HttpClient 客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建 HttpGet 请求
        HttpGet httpGet = new HttpGet("https://www.jianshu.com/shakespeare/notes/39647706/reward_section");
        // 设置长连接
        httpGet.setHeader("Connection", "keep-alive");
        // 设置代理（模拟浏览器版本）
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        // 设置 Cookie
        httpGet.setHeader("Cookie", "UM_distinctid=16442706a09352-0376059833914f-3c604504-1fa400-16442706a0b345; CNZZDATA1262458286=1603637673-1530123020-%7C1530123020; JSESSIONID=805587506F1594AE02DC45845A7216A4");

        CloseableHttpResponse httpResponse = null;
        try {
            // 请求并获得响应结果
            httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            // 输出请求结果
            System.out.println(EntityUtils.toString(httpEntity));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 无论如何必须关闭连接
        finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    void postTest() {
        String json = postTaobao("https://ip.taobao.com/outGetIpInfo", "112.32.138.96");
        Console.log(json);
        TaobaoIpProvider info = gson.fromJson(json, TaobaoIpProvider.class);
        Console.log(info.getCountry());
        ;

    }

    String postTaobao(String url, String ip) {
        // 创建 HttpClient 客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建 HttpPost 请求
        HttpPost httpPost = new HttpPost(url);
        // 设置长连接
        httpPost.setHeader("Connection", "keep-alive");
        // 设置代理（模拟浏览器版本）


        // 创建 HttpPost 参数
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("ip", ip));
        params.add(new BasicNameValuePair("accessKey", "alibaba-inc"));


        CloseableHttpResponse httpResponse = null;
        try {
            // 设置 HttpPost 参数
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            // 输出请求结果
            return EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 无论如何必须关闭连接
        finally {
            try {
                if (httpResponse != null) {
                    httpResponse.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 得到公共ip
     */
    @Test
    void getPublicIp() {
        try {
            Document document = Jsoup.connect("http://mip.chinaz.com/").get();
            System.out.println(document.body().select("body > div.contnull.z-ml5 > h4.mb5.tl.z-tl > span").text());
            System.out.println(document.body().select("body > div.contnull.z-ml5 > h4:nth-child(2) > span").text());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void testIp2Region() {
        Console.log(Util.ip2long("255.255.255.0"));
    }

    /**
     * 得到本机ip
     *
     * @return {@link String}
     * @throws SocketException 套接字例外
     */
    public static String getLocalIp() throws SocketException {
        String localip = null;// 本地IP，如果没有配置外网IP则返回它
        String netip = null;// 外网IP

        Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip = null;
        boolean finded = false;// 是否找到外网IP
        while (netInterfaces.hasMoreElements() && !finded) {
            NetworkInterface ni = netInterfaces.nextElement();
            Enumeration<InetAddress> address = ni.getInetAddresses();
            while (address.hasMoreElements()) {
                ip = address.nextElement();
                if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
                    netip = ip.getHostAddress();
                    finded = true;
                    break;
                } else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
                        && ip.getHostAddress().indexOf(":") == -1) {// 内网IP
                    localip = ip.getHostAddress();
                }
            }
        }

        if (netip != null && !"".equals(netip)) {
            return netip;
        } else {
            return localip;
        }
    }
}
