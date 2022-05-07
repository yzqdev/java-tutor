package com.yzq.mapper.impl;

import com.yzq.mapper.UserMapper;
import com.yzq.model.User;
import com.yzq.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/8/21 11:35
 * @modified By:
 */
public class UserMapperImpl implements UserMapper {
    @Override
    public List<User> getUsers() {
        try (SqlSession session = MybatisUtil.getSqlSessionFactory()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> users = mapper.getUsers();
            session.commit();
            return users;

        }
    }
}
