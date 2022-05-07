package com.yzq.mapper;

import com.yzq.model.User;
import com.yzq.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/8/21 10:25
 * @modified By:
 */
public class UserMapperTest {

    @Test
    public void getUsersTest(){
        //方式一 getmmaper
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            for (User user : mapper.getUsers()) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
