package com.yzq.myannotion.methodAnnote;

/**
 * @Author: Yangzhengqian
 * @Description:
 * @Date:Created time 2020/10/13 14:39
 * @Modified By:
 */
public interface PersonMapper {
    /**
     * 添加anot
     * @param id
     * @param name
     * @param sex
     */
    @Annote(value = "这是第一个注解", userName = "123")
     void addAnote(String id,String name,String sex);

    @Annote(value = "这是第二个注解", userName = "454545")
    void help();
}
