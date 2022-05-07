package com.yzq.mapper;

import com.yzq.mapper.impl.TeacherMapperImpl;
import com.yzq.model.Student;
import com.yzq.model.Teacher;
import com.yzq.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/8/21 16:14
 * @modified By:
 */
public class TeacherMapperTest {
    TeacherMapper teacherMapper = new TeacherMapperImpl();

    @Test
    public void saveTeacherTest() {
        //方式一 getmmaper
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory()) {
            TeacherMapper studentMapper = sqlSession.getMapper(TeacherMapper.class);

            Teacher t1 = new Teacher(1, "yyy", "1");
            Teacher t2 = new Teacher(2, "yyyd", "3");
            Teacher t3 = new Teacher(3, "yyay", "4");
            studentMapper.saveTeacher(t1);
            studentMapper.saveTeacher(t2);
            studentMapper.saveTeacher(t3);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getTeacherFromStu() {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory()) {
            TeacherMapper studentMapper = sqlSession.getMapper(TeacherMapper.class);

            Teacher t1 = new Teacher(1, "yyy", "1");
            Teacher t2 = new Teacher(2, "yyyd", "3");
            Teacher t3 = new Teacher(3, "yyay", "4");
            studentMapper.saveTeacher(t1);
            studentMapper.saveTeacher(t2);
            studentMapper.saveTeacher(t3);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getTeachers() {
        HashMap<String, Object> hashmapp = new HashMap<>();
        hashmapp.put("title", "2");
        List<Teacher> teachers = teacherMapper.getTeachers(hashmapp);
        System.out.println(teachers);
    }

    @Test
    public void updateTeacher() {
        Teacher teacher = teacherMapper.getTeacherById(2);

        teacher.setName("hhhhhhhhhhhhhhhhhhhhhhhhh");
        System.out.println(teacher);
        teacherMapper.updateTeacher(2, teacher);
        System.out.println(teacherMapper.getTeacherById(2));
    }
}
