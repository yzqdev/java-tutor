package com.yzq.hutooltest;

import cn.hutool.core.util.IdUtil;
import org.junit.jupiter.api.Test;

/**
 * @author yanni
 * @date time 2022/1/17 1:02
 * @modified By:
 */
public class IdGen {
    @Test
    public  void genNanoId(){
        System.out.println(IdUtil.nanoId());
        System.out.println(IdUtil.simpleUUID());
        System.out.println(IdUtil.fastUUID());
    }
}
