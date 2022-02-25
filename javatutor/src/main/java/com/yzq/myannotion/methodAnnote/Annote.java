package com.yzq.myannotion.methodAnnote;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Yangzhengqian
 * @Description:
 * @Date:Created time 2020/10/13 14:37
 * @Modified By:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Annote{
    String value();
    String userName();
}
