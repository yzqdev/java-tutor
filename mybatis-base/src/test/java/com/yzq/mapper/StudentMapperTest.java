package com.yzq.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yzq.model.Student;
import com.yzq.model.User;
import com.yzq.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/8/21 10:25
 * @modified By:
 */
public class StudentMapperTest {

    @Test
    public void getStudentsTest() {
        //方式一 getmmaper

        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            PageHelper.startPage(3,2);
            Page<Student> students=studentMapper.getStudents();
            System.out.println(students.getPageSize());
            System.out.println(students);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void saveStudentTest() {
        //方式一 getmmaper
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
