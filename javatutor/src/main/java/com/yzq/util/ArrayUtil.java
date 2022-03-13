package com.yzq.util;

import cn.hutool.core.collection.CollectionUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yanni
 * @date time 2022/2/25 14:38
 * @modified By:
 */
public class ArrayUtil {
    // Set 去重代码示例
    public static <T> Set<T> removeDuplicateBySet(List<T> data) {

        if (CollectionUtil.isEmpty(data)) {
            return new HashSet<>();
        }
        return new HashSet<>(data);
    }

    // List 去重代码示例
    public static <T> List<T> removeDuplicateByList(List<T> data) {

        if (CollectionUtil.isEmpty(data)) {
            return new ArrayList<>();

        }
        List<T> result = new ArrayList<>(data.size());
        for (T current : data) {
            if (!result.contains(current)) {
                result.add(current);
            }
        }
        return result;
    }


}
