package com.yzq.myannotion.methodAnnote;

import java.lang.reflect.Method;

/**
 * @Author: Yangzhengqian
 * @Description:
 * @Date:Created time 2020/10/13 14:41
 * @Modified By:
 */
public class MethodGet implements  PersonMapper{
    public static MethodGet getInstance(Class<PersonMapper> clazz){
        return new MethodGet();
    }
    @Override
    public void addAnote(String id, String name, String sex) {
        getMeth();
    }

    @Override
    public void help() {
        getMeth();
    }

    private void getMeth() {
        Method[] method= PersonMapper.class.getDeclaredMethods();
        for (Method m:method){
            if (m.isAnnotationPresent(Annote.class)){
                String value=m.getAnnotation(Annote.class).value();
                String  userName=m.getAnnotation(Annote.class).userName();
                System.out.println(value );
                System.out.println(userName);
            }
        }
    }
}
