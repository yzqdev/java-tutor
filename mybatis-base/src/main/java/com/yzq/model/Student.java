package com.yzq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/8/21 15:42
 * @modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    /**
     * 多对一
     */
    private Teacher teacher;
}
