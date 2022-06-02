package com.yzq.hutooltest;

import cn.hutool.core.lang.Console;
import cn.hutool.core.net.NetUtil;
import org.junit.jupiter.api.Test;

/**
 * @author yanni
 * @date time 2022/5/24 7:37
 * @modified By:
 */
 class NetUtilTest {
    @Test
    void getIp(){
        Console.log(NetUtil.getLocalhostStr());
        Console.log(NetUtil.localIps());
        Console.log("--------------------------------");
        Console.log(NetUtil.localIpv4s());
        Console.log("ping baidu",NetUtil.ping("www.baidu.com"));
        Console.log("网卡地址:{}",NetUtil.getLocalMacAddress());
        Console.log(NetUtil.getIpByHost("https://hutool.cn"));
    }
}
