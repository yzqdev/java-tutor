package com.yzq;

import com.yzq.mapper.UserMapper;
import com.yzq.mapper.impl.UserMapperImpl;
import com.yzq.model.User;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/8/21 11:34
 * @modified By:
 */
public class MysqlApp {
    public static void main(String[] args) {
        UserMapper userMapper=new UserMapperImpl();
        for (User user : userMapper.getUsers()) {
            System.out.println(user);
        }

    }
}
