package com.yzq.myannotion.classAnnote;

import java.lang.annotation.*;

/**
 * @author yanni
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Info {
      String value() default "tracy";
      boolean isDelete();
}
