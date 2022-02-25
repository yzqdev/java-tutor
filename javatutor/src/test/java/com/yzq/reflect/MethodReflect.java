package com.yzq.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author yanni
 * @date time 2021/10/15 17:37
 * @modified By:
 */
public class MethodReflect {
    @Test
    String[] getParameterNames(Method method) {
        Parameter[] parameters = method.getParameters();
        String[] parameterNames = new String[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Parameter param = parameters[i];
            if (!param.isNamePresent()) {
                return null;
            }
            parameterNames[i] = param.getName();
        }
        return parameterNames;
    }

    @Test
    void methodRef() {

        User u = new User();
        try {
            Method m = u.getClass().getMethod("getName", String.class, String.class);

            System.out.println(m.getParameterCount());


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
