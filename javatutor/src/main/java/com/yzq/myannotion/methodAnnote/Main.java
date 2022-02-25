package com.yzq.myannotion.methodAnnote;

/**
 * @Author: Yangzhengqian
 * @Description:
 * @Date:Created time 2020/10/13 14:44
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        PersonMapper personMapper = MethodGet.getInstance(PersonMapper.class);
        personMapper.addAnote("啊啊啊", "呢么", "女");
        //personMapper.help();

    }
}
