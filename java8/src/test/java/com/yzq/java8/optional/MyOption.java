package com.yzq.java8.optional;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

/**
 * @author yanni
 * @date time 2021/11/30 13:20
 * @modified By:
 */
public class MyOption {
    @Test
    void optionTest() {
        System.out.println(bolTest());
        System.out.println(ifTest());
    }

    Boolean ifTest() {
        List<String> dictCodes = List.of("aaa", "bbb", "ccc", "ddd");
        String dictValue = "aaa";
        if (dictCodes != null && dictCodes.size() > 0) {
            return dictCodes.contains(dictValue);
        } else {
            return false;
        }
    }

    Boolean bolTest() {
        List<String> dictCodes = List.of("aaa", "bbb", "ccc", "ddd");
        String dictValue = "aaa";
        return Optional.of(dictCodes).filter((i) -> dictCodes.size() > 0).map((i) -> dictCodes.contains(dictValue)).orElse(false);

    }
}
