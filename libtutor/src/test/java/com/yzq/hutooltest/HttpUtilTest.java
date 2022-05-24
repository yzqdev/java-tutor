package com.yzq.hutooltest;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpStatus;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import cn.hutool.json.JSONUtil;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author yanni
 * @date time 2022/5/24 8:10
 * @modified By:
 */
public class HttpUtilTest {
    @Test
    void getHttp(){
        // 最简单的HTTP请求，可以自动通过header等信息判断编码，不区分HTTP和HTTPS
        String result1= HttpUtil.get("http://httpbin.org/get");
        Console.log(result1);
// 当无法识别页面编码的时候，可以自定义请求页面的编码
        String result2= HttpUtil.get("http://httpbin.org/get", CharsetUtil.CHARSET_UTF_8);

//可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "北京");

        String result3= HttpUtil.get("https://www.baidu.com", paramMap);
    }

    @Test
    void userAgentTest(){
        String result=HttpUtil.get("http://httpbin.org/user-agent");
        Console.log("user-agent:"+result);
        UserAgent ua = UserAgentUtil.parse(JSONUtil.parseObj(result).getStr("user-agent"));
        Console.log(ua.getOs());
        Console.log(ua.getVersion());
        Console.log(ua.getBrowser());
        Console.log(HttpStatus.HTTP_ACCEPTED);
    }
}
