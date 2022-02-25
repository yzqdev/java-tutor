package com.yzq.tutor.reflection.jdbcs;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
 
/**
 * @author yanni
 */
@Target({METHOD,TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface JDBCConfig {
     String ip();
     int port() default 3306;
     String database();
     String encoding();
     String loginName();
     String password();
}